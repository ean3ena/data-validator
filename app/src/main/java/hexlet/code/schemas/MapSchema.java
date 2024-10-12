package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, String>> {

    public MapSchema sizeof(int size) {
        checks.put("checkSizeof", data -> data == null || data.size() == size);
        return this;
    }

    public MapSchema required() {
        checks.put("checkNullOrEmpty", data -> data != null && !data.isEmpty());
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {

        for (var key : schemas.keySet()) {
            var schema = schemas.get(key);
            checks.put(key, data -> data != null && schema.isValid(data.get(key)));
        }
        return this;
    }

    public boolean isValid(Map<String, String> data) {
        return super.isValid(data);
    }
}
