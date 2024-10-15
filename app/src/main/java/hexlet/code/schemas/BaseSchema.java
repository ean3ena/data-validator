package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    protected boolean required;
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    /**
     * Метод проверяет данные по переданной схеме.
     * @param value проверяемые данные
     * @return true если данные проходят проверку по переданной схеме
     */
    public boolean isValid(T value) {
        if (value == null || Objects.equals(value, "")) {
            return !required;
        }
        for (var check : checks.values()) {
            if (!check.test(value)) {
                return false;
            }
        }
        return true;
    };
}
