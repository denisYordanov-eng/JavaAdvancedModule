package models;

import Interfaces.ListCommands;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ListIteratorTest extends TestCase {


@Test(expected = OperationNotSupportedException.class)
    public  void ListIteratorTestNullList() throws OperationNotSupportedException {
        ListCommands<String> listCommands = new ListIterator<>(null);
    }

    @Test
    public void testMove() throws OperationNotSupportedException {
        ListCommands<String> collection = createList();
        collection.move();
        Assert.assertEquals(1, collection.getCurrentIndex());
    }

    @Test
    public void testMoveMoreThanListElements() throws OperationNotSupportedException {
        ListCommands<String> collection = createList();
        Assert.assertTrue(collection.move());
        Assert.assertTrue(collection.move());
        Assert.assertTrue(collection.move());
        Assert.assertFalse(collection.move());
    }

    @Test
    public void testMoveOneElementList() throws OperationNotSupportedException {
    List<String> oneElement = new ArrayList<>();
    oneElement.add("one");
    ListCommands<String> collection = new ListIterator<>(oneElement);
    collection.move();
    collection.hasNext();
        Assert.assertFalse(collection.hasNext());
    }

    @Test
    public void testHasNextBoolean() throws OperationNotSupportedException {
        ListCommands<String> collection = createList();
        Assert.assertTrue(collection.hasNext());
    }
    public void testPrint() throws OperationNotSupportedException {
        ListCommands<String> collection = createList();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        collection.print();
        Assert.assertEquals("a",baos.toString().trim());
    }



    private ListIterator<String> createList() throws OperationNotSupportedException {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        return new ListIterator<>(list);
    }
}