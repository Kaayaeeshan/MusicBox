package strategy;

import annotation.PatternRole;
import model.Song;
import java.util.Comparator;
import java.util.List;

@PatternRole(pattern = "Strategy", role = "ConcreteStrategy")
public class TitleSortStrategy implements SortStrategy {
    public List<Song> sort(List<Song> songs) {
        return songs.stream()
                .sorted(Comparator.comparing(Song::getTitle, String::compareToIgnoreCase))
                .toList();
    }
    public String name() { return "Title (A-Z)"; }
}
