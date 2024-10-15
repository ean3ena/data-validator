package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema sizeof(int size) {
        checks.put("checkSizeof", data -> data.size() == size);
        return this;
    }

    public MapSchema required() {
        required = true;
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {

        for (var key : schemas.keySet()) {
            var schema = schemas.get(key);
            checks.put(key, data -> schema.isValid((T) data.get(key)));
        }
        return this;
    }
}
