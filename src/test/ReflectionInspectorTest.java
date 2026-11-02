import model.Song;
import reflection.ReflectionInspector;
import strategy.SortStrategy;
import strategy.TitleSortStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReflectionInspectorTest {
    private final ReflectionInspector inspector = new ReflectionInspector();

    @Test
    void songIsFullyEncapsulated() {
        assertTrue(inspector.inspect(Song.class).allFieldsEncapsulated());
    }

    @Test
    void patternRoleReadableOnConcreteStrategy() {
        assertTrue(inspector.describePatternRole(TitleSortStrategy.class).contains("ConcreteStrategy"));
    }

    @Test
    void unannotatedClassReturnsNull() {
        assertNull(inspector.describePatternRole(String.class));
    }

    @Test
    void correctlyConfirmsInterfaceImplemented() {
        assertTrue(inspector.implementsInterface(new TitleSortStrategy(), SortStrategy.class));
    }

    @Test
    void correctlyRejectsNonImplementingObject() {
        assertFalse(inspector.implementsInterface("a string", SortStrategy.class));
    }
}