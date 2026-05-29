package contracts;

import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;


public interface CrudRepository<T extends Modelable> {

    T findByModel(String model) throws NonExistantModelException;

    void add(T item) throws DuplicateModelException;

    T getItem(String model) throws NonExistantModelException;
}
