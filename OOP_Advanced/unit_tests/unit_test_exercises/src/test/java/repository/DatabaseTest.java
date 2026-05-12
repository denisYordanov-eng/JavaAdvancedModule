package repository;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    public static final int ELEMENT_TO_ADD = 1;
    public static final Integer[] NOT_SIXTEEN_ELEMENTS_ARR = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    public static final Integer[] SIXTEEN_ELEMENTS_ARR = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    public static final Integer[] EMPTY_ARR = new Integer[0];

    @Test(expected = OperationNotSupportedException.class)
    public void checkLengthTestNotSixteenElements() throws OperationNotSupportedException {
        Database database = new Database(NOT_SIXTEEN_ELEMENTS_ARR);
    }

    @Test
    public void checkLengthTestSixteenElements() throws OperationNotSupportedException {
        Database database = new Database(SIXTEEN_ELEMENTS_ARR);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddFullArr() throws OperationNotSupportedException {
        Database database = new Database(SIXTEEN_ELEMENTS_ARR);
        database.add(ELEMENT_TO_ADD);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddArrNullValue() throws OperationNotSupportedException {
        Database database = new Database(SIXTEEN_ELEMENTS_ARR);
        database.remove();
        Integer elementToAdd = null;
        database.add(elementToAdd);
    }

    @Test
    public void testAddArr() throws OperationNotSupportedException {
        Database database = new Database(SIXTEEN_ELEMENTS_ARR);
        database.remove();
        database.add(ELEMENT_TO_ADD);
        Integer[] elements = database.fetch();
        Assert.assertEquals(16, elements.length);

        Integer[] databaseElements = database.fetch();
        Assert.assertEquals((Object) ELEMENT_TO_ADD, databaseElements[databaseElements.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveEmptyArr() throws OperationNotSupportedException {
        Database database = new Database(EMPTY_ARR);
    }

    @Test()
    public void testRemoveLastElement() throws OperationNotSupportedException {
        Database database = new Database(SIXTEEN_ELEMENTS_ARR);

        database.remove();

        Integer[] databaseElements = database.fetch();
        int databaseSize = 15;
        Assert.assertEquals(databaseSize, databaseElements.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFetchEmptyArr() throws OperationNotSupportedException {
        Database database = new Database(EMPTY_ARR);
        Integer[] databaseElements = database.fetch();
    }

    @Test
    public void testFetch() throws OperationNotSupportedException {
        Database database = new Database(SIXTEEN_ELEMENTS_ARR);
        database.remove();

        Integer[] databaseElements = database.fetch();
        Integer[] expectedArr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Assert.assertArrayEquals(expectedArr, databaseElements);
    }
}