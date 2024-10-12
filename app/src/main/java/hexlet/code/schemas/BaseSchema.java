package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    public boolean isValid(T obj) {
        for (var check : checks.values()) {
            if (!check.test(obj)) {
                return false;
            }
        }
        return true;
    };
}
