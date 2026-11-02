package library;

import model.PlayTime;
import model.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import strategy.SortStrategy;
import annotation.PatternRole;

@PatternRole(pattern = "Strategy", role = "Context")
public class MusicLibrary {

    private final List<Song> songs = new ArrayList<>();
    private SortStrategy sortStrategy;

    public MusicLibrary(SortStrategy defaultStrategy) {
        this.sortStrategy = defaultStrategy;
    }
    public MusicLibrary() {
        this(null);
    }

    public void setSortStrategy(SortStrategy sortStrategy) { this.sortStrategy = sortStrategy; }
    public List<Song> getSortedSongs() { return sortStrategy.sort(songs); }

    public void addSong(Song song) { songs.add(song); }
    public int size() { return songs.size(); }

    public int removeByTitle(String title) {
        int before = songs.size();
        songs.removeIf(s -> s.getTitle().equalsIgnoreCase(title));
        return before - songs.size();
    }

    public List<Song> search(Predicate<Song> filter) {
        return songs.stream().filter(filter).collect(Collectors.toList());
    }

    public List<Song> findByGenre(String genre) {
        return search(s -> s.getGenre().equalsIgnoreCase(genre));
    }

    public List<Song> findByArtist(String artist) {
        return search(s -> s.getArtist().equalsIgnoreCase(artist));
    }

    public List<Song> findByLyricsContaining(String phrase) {
        return search(s -> s.hasLyrics() && s.hasLyricsContaining(phrase));
    }

    public List<Song> findLongerThan(PlayTime threshold) {
        return search(s -> s.isLongerThan(threshold));
    }

    public Map<String, List<Song>> groupByArtist() {
        return songs.stream().collect(Collectors.groupingBy(Song::getArtist));
    }

    public PlayTime totalDuration() {
        return songs.stream()
                .map(Song::getDuration)
                .reduce(PlayTime.ofSeconds(0), PlayTime::plus);
    }

    public Optional<Double> averageDurationOf(Predicate<Song> filter) {
        return songs.stream()
                .filter(filter)
                .mapToInt(s -> s.getDuration().totalSeconds())
                .average()
                .stream().boxed().findFirst();
    }

    public List<Song> allSongs() { return List.copyOf(songs); }
}