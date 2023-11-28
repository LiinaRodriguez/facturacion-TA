package metodofactory.util;

import java.util.Objects;

public class Container<T, U> {
    private T first;
    private U second;

    public Container(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container<?, ?> container = (Container<?, ?>) o;
        return Objects.equals(first, container.first) &&
                Objects.equals(second, container.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "Container{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
