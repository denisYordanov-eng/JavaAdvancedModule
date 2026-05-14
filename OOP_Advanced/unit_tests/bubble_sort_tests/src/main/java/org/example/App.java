package org.example;

import Model.Bubble;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        List<Integer> list = new ArrayList<Integer>();
        list.add(20);
        list.add(5);
        list.add(7);
        list.add(6);
        Bubble bubble = new Bubble(list);
        bubble.bubbleSort();
        System.out.println(bubble);
    }
}
