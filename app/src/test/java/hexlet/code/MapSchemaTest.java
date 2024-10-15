package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
        assertTrue(schema.isValid(new HashMap<>())); // true

        var data = new HashMap<String, String>();

        data.put("key1", "value1");
        assertTrue(schema.isValid(data)); // true

        schema.sizeof(2);

        assertFalse(schema.isValid(data)); // false
        data.put("key2", "value2");
        assertTrue(schema.isValid(data)); // true
    }

    @Test
    void stringSchemaTest2() {
        var schema = v.map();

        assertTrue(schema.isValid(null)); // true
        schema.sizeof(2);
        assertTrue(schema.isValid(null)); // true
        schema.required();
        assertFalse(schema.isValid(null)); // false
    }

    @Test
    void stringSchemaTest3() {

        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));

        var schema = v.map().sizeof(2).shape(schemas);

        Map<String, String> data1 = new HashMap<>();
        data1.put("firstName", "John");
        data1.put("lastName", "Smith");
        assertTrue(schema.isValid(data1)); // true

        Map<String, String> data2 = new HashMap<>();
        data2.put("firstName", "John");
        data2.put("lastName", null);
        assertFalse(schema.isValid(data2)); // false

        Map<String, String> data3 = new HashMap<>();
        data3.put("firstName", "Anna");
        data3.put("lastName", "B");
        assertFalse(schema.isValid(data3)); // false
    }
}
