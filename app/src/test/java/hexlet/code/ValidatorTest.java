package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorTest {

    private static Validator v;

    @BeforeAll
    static void beforeAll() {
        v = new Validator();
    }

    @Test
    void stringSchemaTest1() {
        var schema = v.string();
        assertTrue(schema.isValid("")); // true
        assertTrue(schema.isValid(null)); // true
        schema.required();
        assertFalse(schema.isValid(null)); // false
        assertFalse(schema.isValid("")); // false
    }

    @Test
    void stringSchemaTest2() {
        var schema = v.string();
        assertTrue(schema.isValid("hexlet")); // true
        assertFalse(schema.minLength(10).isValid("Hexlet")); // false
    }

    @Test
    void stringSchemaTest3() {
        var schema = v.string();
        schema.required();

        assertTrue(schema.isValid("what does the fox say")); // true
        assertTrue(schema.isValid("hexlet")); // true

        assertTrue(schema.contains("wh").isValid("what does the fox say")); // true
        assertTrue(schema.contains("what").isValid("what does the fox say")); // true
        assertFalse(schema.contains("whatthe").isValid("what does the fox say")); // false

        var schema1 = v.string();
        assertTrue(schema1.minLength(10).minLength(4).isValid("Hexlet")); // true
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
