package inferno_infinity_compareTo_feature.repositories;

public interface Repository <T>{
    void add(T element);
    T get(String name);
}
