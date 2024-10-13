package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    /**
     * Метод проверяет данные по переданной схеме
     * @param obj проверяемые данные
     * @return true если данные проходят проверку по переданной схеме
     */
    public boolean isValid(T obj) {
        for (var check : checks.values()) {
            if (!check.test(obj)) {
                return false;
            }
        }
        return true;
    };
}
