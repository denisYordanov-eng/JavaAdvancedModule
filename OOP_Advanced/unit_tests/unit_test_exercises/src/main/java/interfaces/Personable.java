package interfaces;

import javax.naming.OperationNotSupportedException;

public interface Personable<Person> {
    void addPerson(Person person) throws OperationNotSupportedException;
    void removePerson() throws OperationNotSupportedException;
    Person findByUsername(String username) throws OperationNotSupportedException;
    Person findById(Long id) throws OperationNotSupportedException;
}
