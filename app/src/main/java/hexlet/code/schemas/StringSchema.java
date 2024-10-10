package hexlet.code.schemas;

public class StringSchema {

    private boolean require;
    private int currentMinLength;
    private String currentSubstring = "";

    public StringSchema minLength(int minLength) {
        this.currentMinLength = minLength;
        return this;
    }

    public StringSchema contains(String substring) {
        this.currentSubstring = substring;
        return this;
    }

    public StringSchema required() {
        this.require = true;
        return this;
    }

    public boolean isValid(String text) {

        if (text == null || text.isEmpty()) {
            return !require;
        }
        if (text.length() < currentMinLength) {
            return false;
        }
        if (!text.contains(currentSubstring)) {
            return false;
        }
        return true;
    }
}
