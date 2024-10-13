package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema positive() {
        checks.put("checkPositive", number -> number == null || number > 0);
        return this;
    }

    public NumberSchema range(int left, int right) {
        checks.put("checkRange", number -> number == null
                || (number >= left && number <= right));
        return this;
    }

    public NumberSchema required() {
        checks.put("checkNull", Objects::nonNull);
        return this;
    }

    public boolean isValid(Integer number) {
        return super.isValid(number);
    }
}
