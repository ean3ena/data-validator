package hexlet.code.schemas;

public class NumberSchema {

    private boolean require;
    private boolean positive;
    private boolean inRange;
    private int[] range;

    public NumberSchema positive() {
        this.positive = true;
        return this;
    }

    public NumberSchema range(int left, int right) {
        this.range = new int[]{left, right};
        this.inRange = true;
        return this;
    }

    public NumberSchema required() {
        this.require = true;
        return this;
    }

    public boolean isValid(Integer number) {

        if (number == null) {
            return !require;
        }
        if (positive && number <= 0) {
            return false;
        }
        if (inRange && (number < range[0] || number > range[1])) {
            return false;
        }
        return true;
    }
}
