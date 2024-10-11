package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapSchemaTest {

    private static Validator v;

    @BeforeAll
    static void beforeAll() {
        v = new Validator();
    }

    @Test
    void stringSchemaTest1() {
        var schema = v.map();
        assertTrue(schema.isValid(null)); // true
        schema.required();
        assertFalse(schema.isValid(null)); // false
        assertFalse(schema.isValid(new HashMap<>())); // false
    }

    @Test
    void stringSchemaTest2() {
        var schema = v.map();
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data)); // true
        schema.sizeof(2);
        assertFalse(schema.isValid(data)); // false
        data.put("key2", "value2");
        assertTrue(schema.isValid(data)); // true
    }
}
