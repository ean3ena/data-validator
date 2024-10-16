package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema minLength(int minLength) {
        checks.put("checkMinLength", text -> text.length() >= minLength);
        return this;
    }

    public StringSchema contains(String substring) {
        checks.put("checkSubstring", text -> text.contains(substring));
        return this;
    }

    public StringSchema required() {
        checks.put("checkEmpty", data -> !data.isEmpty());
        required = true;
        return this;
    }
}
