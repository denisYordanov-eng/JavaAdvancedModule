package inferno_infinity.repositories;

public interface Repository <T>{
    void add(T element);
    T get(String name);
}
