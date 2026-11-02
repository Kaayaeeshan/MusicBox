import model.PlayTime;
import model.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SongTest {
    private Song song;

    @BeforeEach
    void setUp() {
        song = new Song("Shape of you", "Ed Sheeran", "Divide", "Pop",
                PlayTime.ofMinutesSeconds("4:24"), "he club isn't the best place to find a lover");
    }

    @Test void matchesFindsByTitle() { assertTrue(song.matches("shape")); }
    @Test void matchesRejectsUnrelated() { assertFalse(song.matches("mozart")); }
    @Test void hasLyricsTrueWhenSupplied() { assertTrue(song.hasLyrics()); }
    @Test void hasLyricsContainingFindsPhrase() { assertTrue(song.hasLyricsContaining("best place")); }
    @Test void hasLyricsContainingRejectsAbsentPhrase() { assertFalse(song.hasLyricsContaining("guitar solo")); }

    @Test
    void noLyricsSuppliedMeansHasLyricsFalse() {
        Song instrumental = new Song("Instrumental", "Someone", "Album", "Genre",
                PlayTime.ofSeconds(60), null);
        assertFalse(instrumental.hasLyrics());
    }
}
