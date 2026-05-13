package repository;


import Models.Person;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;


public class PeopleDatabaseTest {
    private static final Long ID_NOT_PRESENT = Long.valueOf(20);
    public static final Long ID_PRESENT = Long.valueOf(2);
    public static final String NAME_NOT_PRESENT = "Name";
    public static final String NAME_PRESENT = "user4";
    public static final String NAME_PRESENT_CASE_SENSITIVE = "User4";
    public static final int NEGATIVE_ID = -1;

    @Test(expected = OperationNotSupportedException.class)
    public void PeopleDatabaseTestNotEnoughPeople() throws OperationNotSupportedException {
        Person[] people = new Person[10];
        for (int i = 0; i < people.length; i++) {
            Long currentId = Long.valueOf(i + 1);
            people[i] = new Person("user" + i, currentId);
        }
        PeopleDatabase peopleDatabase = new PeopleDatabase(people);
    }

    @Test()
    public void PeopleDatabaseTestEnoughPeople() throws OperationNotSupportedException {
        PeopleDatabase peopleDatabase = createDatabase();
        Assert.assertEquals(16, peopleDatabase.getArraySize());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddPersonNullId() throws OperationNotSupportedException {
        PeopleDatabase peopleDatabase = createDatabase();
        peopleDatabase.removePerson();
        Long idNull = null;
        Person person = new Person("user17", idNull);
        peopleDatabase.addPerson(person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddPersonNegativeId() throws OperationNotSupportedException {
        PeopleDatabase peopleDatabase = createDatabase();
        peopleDatabase.removePerson();
        Person person = new Person("user20", Long.valueOf(NEGATIVE_ID));
        peopleDatabase.addPerson(person);
    }

    @Test
    public void testAddPerson() throws OperationNotSupportedException {
        PeopleDatabase peopleDatabase = createDatabase();
        peopleDatabase.removePerson();
        peopleDatabase.addPerson(new Person(NAME_NOT_PRESENT, ID_NOT_PRESENT));
        Assert.assertEquals(16, peopleDatabase.getArraySize());
    }

    @Test
    public void testRemovePersonPeopleArr() throws OperationNotSupportedException {
        PeopleDatabase peopleDatabase = createDatabase();
        peopleDatabase.removePerson();
        Assert.assertEquals(15, peopleDatabase.getArraySize());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemovePersonEmptyPeopleArr() throws OperationNotSupportedException {
        PeopleDatabase peopleDatabase = createDatabase();
        for (int i = 0; i < 16; i++) {
            peopleDatabase.removePerson();
        }
        peopleDatabase.removePerson();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameNotPresentUsername() throws OperationNotSupportedException {
        PeopleDatabase peopleDatabase = createDatabase();
        peopleDatabase.findByUsername(NAME_NOT_PRESENT);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameEqualsNull() throws OperationNotSupportedException {
        PeopleDatabase peopleDatabase = createDatabase();
        peopleDatabase.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameCaseSensitive() throws OperationNotSupportedException {

        PeopleDatabase peopleDatabase = createDatabase();
        peopleDatabase.findByUsername(NAME_PRESENT_CASE_SENSITIVE);
    }

    @Test
    public void testFindByUsernamePresentUsername() throws OperationNotSupportedException {
        PeopleDatabase peopleDatabase = createDatabase();
        Person targetPerson = peopleDatabase.findByUsername(NAME_PRESENT);

        Assert.assertEquals(NAME_PRESENT, targetPerson.getUserName());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdNull() throws OperationNotSupportedException {
        PeopleDatabase peopleDatabase = createDatabase();
        peopleDatabase.findById(null);
    }

    @Test()
    public void testFindByIdPresentId() throws OperationNotSupportedException {
        PeopleDatabase peopleDatabase = createDatabase();
        peopleDatabase.findById(ID_PRESENT);

        Assert.assertEquals(ID_PRESENT, peopleDatabase.findById(ID_PRESENT).getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdEqualIdNotPresentId() throws OperationNotSupportedException {
        PeopleDatabase peopleDatabase = createDatabase();
        peopleDatabase.findById(ID_NOT_PRESENT);
    }

    private PeopleDatabase createDatabase() throws OperationNotSupportedException {
        Person[] people = new Person[16];

        for (int i = 0; i < people.length; i++) {
            people[i] = new Person("user" + i, (long) (i + 1));
        }

        return new PeopleDatabase(people);
    }
}