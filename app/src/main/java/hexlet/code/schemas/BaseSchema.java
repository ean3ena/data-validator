package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    protected boolean required;
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    public BaseSchema() {
        checks.put("checkNull", Objects::nonNull);
    }

    /**
     * Метод проверяет данные по переданной схеме.
     * @param value проверяемые данные
     * @return true если данные проходят проверку по переданной схеме
     */
    public boolean isValid(T value) {
        if (!required) {
            var checkNull = checks.get("checkNull");
            if (!checkNull.test(value)) {
                return true;
            }
        }
        for (var check : checks.values()) {
            if (!check.test(value)) {
                return false;
            }
        }
        return true;
    };
}
