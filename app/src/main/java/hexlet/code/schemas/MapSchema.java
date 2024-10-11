package hexlet.code.schemas;

import java.util.Map;

public class MapSchema {

    private boolean require;
    private boolean requireSize;
    private int currentSize;

    public MapSchema sizeof(int size) {
        this.currentSize = size;
        this.requireSize = true;
        return this;
    }

    public MapSchema required() {
        this.require = true;
        return this;
    }

    public boolean isValid(Map<String, String> data) {

        if (data == null || data.isEmpty()) {
            return !require;
        }
        if (requireSize && data.size() != currentSize) {
            return false;
        }
        return true;
    }
}
