package p03_GenericSwapMethodStrings;

public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %s%n", this.value.getClass().getName(), this.value));
        return sb.toString();
    }
}
