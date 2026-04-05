package collection_hierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        AddCollection<String> addCollection = new AddCollectionImpl<>();

        AddRemoveCollection<String> addRemoveCollection = new AddRemoveCollectionImpl<>();

        MyList<String> myList = new MyListImpl<>();

        String[] tokens = br.readLine().split("\\s+");

        int countOfRemoveElements = Integer.parseInt(br.readLine());

        printIndexes(tokens, addCollection, addRemoveCollection, myList);

        printRemovedElements(tokens, addCollection, addRemoveCollection, myList, countOfRemoveElements);

    }

    private static void printRemovedElements(String[] tokens, AddCollection<String> addCollection
            , AddRemoveCollection<String> addRemoveCollection, MyList<String> myList, int countOfRemoveElements) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < countOfRemoveElements; i++) {
            sb1.append(addRemoveCollection.remove()).append(" ");
            sb2.append(myList.remove()).append(" ");
        }

        System.out.println(sb1.toString().trim());
        System.out.println(sb2.toString().trim());
    }

    private static void printIndexes(String[] tokens, AddCollection<String> addCollection, AddRemoveCollection<String> addRemoveCollection, MyList<String> myList) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        for (String token : tokens) {
            sb1.append(addCollection.add(token)).append(" ");
            sb2.append(addRemoveCollection.add(token)).append(" ");
            sb3.append(myList.add(token)).append(" ");
        }

        System.out.println(sb1.toString().trim());
        System.out.println(sb2.toString().trim());
        System.out.println(sb3.toString().trim());

    }


}
