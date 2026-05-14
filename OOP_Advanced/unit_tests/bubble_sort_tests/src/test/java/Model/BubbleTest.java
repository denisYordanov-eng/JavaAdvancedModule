package Model;

import Interface.BubbleSortable;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BubbleTest {


    @Test
    public void bubbleSort() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(20);
        list.add(5);
        list.add(1);
        BubbleSortable listy = new Bubble(list);
        listy.bubbleSort();
        String expected = "1 5 20";
        Assert.assertEquals(expected, listy.toString());
    }
    @Test(expected=IllegalArgumentException.class)
    public void ListyEmptyList() {
        List<Integer> list = new ArrayList<Integer>();
        BubbleSortable listy = new Bubble(list);
    }

    @Test(expected=IllegalArgumentException.class)
    public void ListyNullList() {
        BubbleSortable listy = new Bubble(null);
    }


    @Test
    public void testToString() {
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(5);
        list.add(1);
        BubbleSortable listy = new Bubble(list);
        String listToString = "20 5 1";
        Assert.assertEquals(listToString, listy.toString());
    }
}