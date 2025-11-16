package ObjectsClassesAndCollections_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // using TreeSet because it's order first put vip which starts with a digit
        // then put normal guests alphabetically ordered
        Set<String> guests = new TreeSet<>();

        fillTheSetWithGuests(guests,br);

         removeArrivedGuests(guests,br);

        printGuestDidNotCome(guests);
    }

    private static void printGuestDidNotCome(Set<String> guests) {
        //print the number of the guests that did not come
        System.out.println(guests.size());
        //print  the names of guest that did not come
        for (String guestDidNotCome : guests) {
            System.out.println(guestDidNotCome);
        }
    }

    private static void removeArrivedGuests(Set<String> guests, BufferedReader br) throws IOException {
        //remove guests that come to the party
        String guestArrived = br.readLine();
        //if guestArrived equals "END" it means that no more guests will come
        while (!guestArrived.equals("END")) {
            guests.remove(guestArrived);
            guestArrived = br.readLine();
        }
    }

    private static void fillTheSetWithGuests(Set<String> guests, BufferedReader br) throws IOException {
        //read input name list
        String input = br.readLine();
        while (!input.equals("PARTY")) {
            //add current name
            guests.add(input);
            //update name
            input = br.readLine();
        }
    }
}
