package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema positive() {
        checks.put("checkPositive", number -> number > 0);
        return this;
    }

    public NumberSchema range(int left, int right) {
        checks.put("checkRange", number -> number >= left && number <= right);
        return this;
    }

    public NumberSchema required() {
        required = true;
        return this;
    }
}
