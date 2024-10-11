package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringSchemaTest {

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
}
