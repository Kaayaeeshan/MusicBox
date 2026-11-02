import library.MusicLibrary;
import model.PlayTime;
import model.Song;
import strategy.TitleSortStrategy;
import strategy.ArtistSortStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MusicLibraryTest {
    private MusicLibrary library;

    @BeforeEach
    void setUp() {
        library = new MusicLibrary(new TitleSortStrategy());
        library.addSong(new Song("B Song", "Zeta", "Album1", "Rock", PlayTime.ofMinutesSeconds("3:00"), null));
        library.addSong(new Song("A Song", "Alpha", "Album2", "Pop", PlayTime.ofMinutesSeconds("4:00"), "walking home"));
    }

    @Test
    void titleSortOrdersAlphabetically() {
        assertEquals("A Song", library.getSortedSongs().get(0).getTitle());
    }

    @Test
    void artistSortOrdersByArtist() {
        library.setSortStrategy(new ArtistSortStrategy());
        assertEquals("Alpha", library.getSortedSongs().get(0).getArtist());
    }

    @Test
    void findByLyricsContainingFindsMatch() {
        assertEquals(1, library.findByLyricsContaining("walking").size());
    }

    @Test
    void totalDurationSumsCorrectly() {
        assertEquals(PlayTime.ofMinutesSeconds("7:00"), library.totalDuration());
    }

    @Test
    void removeByTitleDeletesMatchingSong() {
        int removed = library.removeByTitle("A Song");
        assertEquals(1, removed);
        assertTrue(library.findByGenre("Pop").isEmpty());
    }

    @Test
    void removeByTitleIsCaseInsensitive() {
        int removed = library.removeByTitle("a song");
        assertEquals(1, removed);
    }

    @Test
    void removeByTitleReturnsZeroWhenNoMatch() {
        int removed = library.removeByTitle("Nonexistent Song");
        assertEquals(0, removed);
    }
}