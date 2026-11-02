import model.PlayTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayTimeTest {
    @Test
    void parsesValidMinutesSeconds() {
        assertEquals(264, PlayTime.ofMinutesSeconds("4:24").totalSeconds());
    }
    @Test
    void rejectsMalformedString() {
        assertThrows(IllegalArgumentException.class, () -> PlayTime.ofMinutesSeconds("bad"));
    }
    @Test
    void rejectsNegativeSeconds() {
        assertThrows(IllegalArgumentException.class, () -> PlayTime.ofSeconds(-1));
    }
    @Test
    void plusAddsDurations() {
        assertEquals(PlayTime.ofMinutesSeconds("5:30"),
                PlayTime.ofMinutesSeconds("2:00").plus(PlayTime.ofMinutesSeconds("3:30")));
    }
}
