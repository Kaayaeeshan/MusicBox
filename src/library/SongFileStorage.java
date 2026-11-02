package library;

import model.PlayTime;
import model.Song;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SongFileStorage {

    public void save(MusicLibrary library, String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (Song song : library.allSongs()) {
            sb.append(escape(song.getTitle())).append(",")
                    .append(escape(song.getArtist())).append(",")
                    .append(escape(song.getAlbum())).append(",")
                    .append(escape(song.getGenre())).append(",")
                    .append(song.getDuration().totalSeconds()).append(",")
                    .append(escape(song.getLyrics()))
                    .append("\n");
        }
        Files.writeString(Path.of(filePath), sb.toString(), StandardCharsets.UTF_8);
    }

    public void loadInto(MusicLibrary library, String filePath) throws IOException {
        Path path = Path.of(filePath);
        if (!Files.exists(path)) {
            return;
        }
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        for (String line : lines) {
            if (line.isBlank()) continue;
            String[] fields = splitCsvLine(line);
            if (fields.length < 6) continue;
            String title = fields[0];
            String artist = fields[1];
            String album = fields[2];
            String genre = fields[3];
            int totalSeconds = Integer.parseInt(fields[4]);
            String lyrics = fields[5];
            library.addSong(new Song(title, artist, album, genre, PlayTime.ofSeconds(totalSeconds), lyrics));
        }
    }

    private String escape(String value) {
        if (value == null) value = "";
        String withEscapedNewlines = value.replace("\n", "\\n");
        String withEscapedQuotes = withEscapedNewlines.replace("\"", "\"\"");
        return "\"" + withEscapedQuotes + "\"";
    }

    private String[] splitCsvLine(String line) {
        List<String> fields = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (inQuotes) {
                if (c == '"' && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    current.append('"');
                    i++;
                } else if (c == '"') {
                    inQuotes = false;
                } else {
                    current.append(c);
                }
            } else {
                if (c == '"') {
                    inQuotes = true;
                } else if (c == ',') {
                    fields.add(current.toString().replace("\\n", "\n"));
                    current.setLength(0);
                } else {
                    current.append(c);
                }
            }
        }
        fields.add(current.toString().replace("\\n", "\n"));
        return fields.toArray(new String[0]);
    }
}