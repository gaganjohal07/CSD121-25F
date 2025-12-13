package lab4.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Col.from(...)
 */
public class ColTest {

    @Test
    void from_validNumericInputs() {
        assertEquals(Col.Left, Col.from("1"));
        assertEquals(Col.Middle, Col.from("2"));
        assertEquals(Col.Right, Col.from("3"));
    }

    @Test
    void from_validLetterInputs_lowercase() {
        assertEquals(Col.Left, Col.from("l"));
        assertEquals(Col.Middle, Col.from("m"));
        assertEquals(Col.Middle, Col.from("c"));
        assertEquals(Col.Right, Col.from("r"));
    }

    @Test
    void from_validLetterInputs_uppercase() {
        assertEquals(Col.Left, Col.from("L"));
        assertEquals(Col.Middle, Col.from("M"));
        assertEquals(Col.Middle, Col.from("C"));
        assertEquals(Col.Right, Col.from("R"));
    }

    @Test
    void from_invalidInputs_throwException() {
        assertThrows(IllegalArgumentException.class, () -> Col.from("x"));
        assertThrows(IllegalArgumentException.class, () -> Col.from("0"));
        assertThrows(IllegalArgumentException.class, () -> Col.from("4"));
        assertThrows(IllegalArgumentException.class, () -> Col.from(""));
        assertThrows(IllegalArgumentException.class, () -> Col.from("left"));
    }

    @Test
    void from_nullInput_throwsException() {
        assertThrows(NullPointerException.class, () -> Col.from(null));
    }
}
