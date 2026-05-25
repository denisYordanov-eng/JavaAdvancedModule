package p03_employee_info;

public interface Formatter<T> {
    String format(Iterable<T> elements);
}
