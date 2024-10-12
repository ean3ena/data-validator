package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema minLength(int minLength) {
        checks.put("checkMinLength", text -> text == null || text.length() >= minLength);
        return this;
    }

    public StringSchema contains(String substring) {
        checks.put("checkSubstring", text -> text == null || text.contains(substring));
        return this;
    }

    public StringSchema required() {
        checks.put("checkNullOrEmpty", text -> text != null && !text.isEmpty());
        return this;
    }

    public boolean isValid(String text) {
        return super.isValid(text);
    }
}
