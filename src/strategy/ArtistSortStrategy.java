package strategy;

import annotation.PatternRole;
import model.Song;
import java.util.Comparator;
import java.util.List;

@PatternRole(pattern = "Strategy", role = "ConcreteStrategy")
public class ArtistSortStrategy implements SortStrategy {
    public List<Song> sort(List<Song> songs) {
        return songs.stream()
                .sorted(Comparator.comparing(Song::getArtist, String::compareToIgnoreCase)
                        .thenComparing(Song::getTitle, String::compareToIgnoreCase))
                .toList();
    }
    public String name() { return "Artist (A-Z)"; }
}
