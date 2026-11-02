import library.MusicLibrary;
import library.SongFileStorage;
import model.PlayTime;
import model.Song;
import strategy.TitleSortStrategy;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
    private static final Scanner in = new Scanner(System.in);
    private static final MusicLibrary library = new MusicLibrary(new TitleSortStrategy());
    private static final SongFileStorage storage = new SongFileStorage();
    private static final String FILE_PATH = "musicbox_songs.csv";

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n1. Add  2. Search lyrics  3. List all  4. Save  5. Load  6. Delete  7. View lyrics  0. Exit");
            switch (in.nextLine().trim()) {
                case "1" -> addSong();
                case "2" -> searchLyrics();
                case "3" -> listAll();
                case "4" -> saveToFile();
                case "5" -> loadFromFile();
                case "6" -> deleteSong();
                case "7" -> viewLyrics();
                case "0" -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addSong() {
        System.out.print("Title: "); String title = in.nextLine();
        System.out.print("Artist: "); String artist = in.nextLine();
        System.out.print("Album: "); String album = in.nextLine();
        System.out.print("Genre: "); String genre = in.nextLine();
        System.out.print("Duration (mm:ss): "); String duration = in.nextLine();

        System.out.println("Lyrics (paste multiple lines, then press Enter on an empty line to finish):");
        StringBuilder lyricsBuilder = new StringBuilder();
        String line;
        while (!(line = in.nextLine()).isEmpty()) {
            lyricsBuilder.append(line).append("\n");
        }
        String lyrics = lyricsBuilder.toString().trim();

        library.addSong(new Song(title, artist, album, genre, PlayTime.ofMinutesSeconds(duration), lyrics));
        System.out.println("Added.");
    }

    private static void searchLyrics() {
        System.out.print("Phrase: ");
        List<Song> results = library.findByLyricsContaining(in.nextLine());
        results.forEach(s -> System.out.println("  " + s.getTitle()));
    }

    private static void listAll() {
        library.getSortedSongs().forEach(s -> System.out.println("  " + s));
    }

    private static void saveToFile() {
        try {
            storage.save(library, FILE_PATH);
            System.out.println("Saved " + library.size() + " song(s) to " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Could not save: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        try {
            storage.loadInto(library, FILE_PATH);
            System.out.println("Library now has " + library.size() + " song(s) after loading.");
        } catch (IOException e) {
            System.out.println("Could not load: " + e.getMessage());
        }
    }

    private static void deleteSong() {
        System.out.print("Title to delete: ");
        int removed = library.removeByTitle(in.nextLine().trim());
        System.out.println(removed > 0 ? removed + " song(s) removed." : "No song found with that title.");
    }

    private static void viewLyrics() {
        System.out.print("Title: ");
        String title = in.nextLine().trim();
        List<Song> matches = library.allSongs().stream()
                .filter(s -> s.getTitle().equalsIgnoreCase(title))
                .toList();
        if (matches.isEmpty()) {
            System.out.println("No song found with that title.");
            return;
        }
        for (Song s : matches) {
            System.out.println("\n" + s.getTitle() + " - " + s.getArtist());
            if (s.hasLyrics()) {
                System.out.println(s.getLyrics());
            } else {
                System.out.println("(no lyrics stored for this song)");
            }
        }
    }
}