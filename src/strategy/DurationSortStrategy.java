package strategy;

import annotation.PatternRole;
import model.Song;
import java.util.Comparator;
import java.util.List;

@PatternRole(pattern = "Strategy", role = "ConcreteStrategy")
public class DurationSortStrategy implements SortStrategy {
    private final boolean longestFirst;

    public DurationSortStrategy(boolean longestFirst) {
        this.longestFirst = longestFirst;
    }

    public List<Song> sort(List<Song> songs) {
        Comparator<Song> byDuration = Comparator.comparing(Song::getDuration);
        if (longestFirst) byDuration = byDuration.reversed();
        return songs.stream().sorted(byDuration).toList();
    }

    public String name() {
        return longestFirst ? "Duration (Longest first)" : "Duration (Shortest first)";
    }
}
