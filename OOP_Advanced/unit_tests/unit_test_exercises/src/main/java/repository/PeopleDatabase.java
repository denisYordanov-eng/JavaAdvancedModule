package repository;

import Models.Person;

import interfaces.Personable;

import javax.naming.OperationNotSupportedException;



public class PeopleDatabase implements Personable<Person> {
    private Person[] people;
    private int arraySize;


    public PeopleDatabase(Person... people) throws OperationNotSupportedException {
        if (people.length != 16) {
            throw new OperationNotSupportedException("There aren't 16 people!");
        }
        this.people = new Person[16];
        for (int i = 0; i < 16; i++) {
            this.people[i] = people[i];
        }
        arraySize = people.length;
    }

    public int getArraySize() {
        return arraySize;
    }

    @Override
    public void addPerson(Person person) throws OperationNotSupportedException {
        Long targetId = person.getId();
        String targetUserName = person.getUserName();
        if ( targetId == null || targetId < 0) {
            throw new OperationNotSupportedException("Invalid id!");
        }
        for (int j = 0; j < arraySize; j++) {
            if (people[j].getId() == targetId || people[j].getUserName().equals(targetUserName)) {
                throw new OperationNotSupportedException("Person already exists!");
            }
        }
        if (arraySize >= 16) {
            throw new OperationNotSupportedException("People database is full!");
        }
        people[arraySize++] = person;
    }

    @Override
    public void removePerson() throws OperationNotSupportedException {
        if (this.arraySize == 0) {
            throw new OperationNotSupportedException("People database is empty!");
        }
        people[arraySize - 1] = null;
        --arraySize;
    }

    @Override
    public Person findByUsername(String username) throws OperationNotSupportedException {
        if(username == null) {
            throw  new OperationNotSupportedException("Username cannot be null!");
        }
       for (int i = 0; i < arraySize; i++) {
           if (people[i].getUserName().equals(username)) {
               return people[i];
           }
       }
        throw new OperationNotSupportedException("Username not found!");
    }

    @Override
    public Person findById(Long id) throws OperationNotSupportedException {
        if(id == null) {
            throw new OperationNotSupportedException("Id cannot be null!");
        }
        for (int i = 0; i < arraySize; i++) {
            if(people[i].getId() == id) {
                return people[i];
            }
        }
       throw new OperationNotSupportedException("Person not found!");
    }
}
