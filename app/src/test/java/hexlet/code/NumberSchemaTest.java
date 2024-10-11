package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberSchemaTest {

    private static Validator v;

    @BeforeAll
    static void beforeAll() {
        v = new Validator();
    }

    @Test
    void numberSchemaTest1() {
        var schema = v.number();
        assertTrue(schema.isValid(5)); // true
        assertTrue(schema.isValid(null)); // true
        assertTrue(schema.positive().isValid(null)); // true
        schema.required();
        assertFalse(schema.isValid(null)); // false
    }

    @Test
    void numberSchemaTest2() {
        var schema = v.number();
        assertTrue(schema.isValid(10)); // true
        assertTrue(schema.isValid(-10)); // true
        schema.positive();
        assertFalse(schema.isValid(-10)); // false
        assertFalse(schema.isValid(0)); // false
    }

    @Test
    void numberSchemaTest3() {
        var schema = v.number();
        schema.range(5, 10);
        schema.positive();

        assertTrue(schema.isValid(5)); // true
        assertTrue(schema.isValid(10)); // true
        assertTrue(schema.isValid(7)); // true

        assertFalse(schema.isValid(4)); // false
        assertFalse(schema.isValid(11)); // false
        assertFalse(schema.isValid(-1)); // false

        var schema1 = v.number();
        assertTrue(schema1.isValid(null)); // true
    }
}
