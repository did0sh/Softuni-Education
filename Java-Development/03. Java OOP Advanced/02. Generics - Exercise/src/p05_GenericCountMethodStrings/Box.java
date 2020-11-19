package p05_GenericCountMethodStrings;

public class Box<T extends Comparable<T>> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public boolean isGreater(Box<T> other){
        if (this.value.compareTo(other.value) > 0){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %s%n", this.value.getClass().getName(), this.value));
        return sb.toString();
    }
}
