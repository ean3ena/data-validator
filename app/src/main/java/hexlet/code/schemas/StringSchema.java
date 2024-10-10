package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class StringSchema {

    private boolean require = false;
    private Map<String, Object> cheks;

    public StringSchema() {
        this.cheks = new HashMap<>();
    }

    public StringSchema minLength(int minLength) {
        this.cheks.put("minLength", minLength);
        return this;
    }

    public StringSchema contains(String substring) {
        this.cheks.put("contains", substring);
        return this;
    }

    public StringSchema required() {
        this.require = true;
        return this;
    }

    public boolean isValid(String text) {

        if (require && (text == null || text.isEmpty())) {
            return false;
        }

        for (var key : cheks.keySet()) {
            if (key.equals("minLength") && text.length() < (int) cheks.get(key)) {
                return false;
            }
            if (key.equals("contains") && !text.contains((String) cheks.get(key))) {
                return false;
            }
        }
        return true;
    }
}
