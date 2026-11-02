package strategy;

import annotation.PatternRole;
import model.Song;
import java.util.List;

@PatternRole(pattern = "Strategy", role = "Strategy (interface)")
public interface SortStrategy {
    List<Song> sort(List<Song> songs);
    String name();
}
