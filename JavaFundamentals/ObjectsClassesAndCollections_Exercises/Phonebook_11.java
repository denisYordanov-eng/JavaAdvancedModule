package ObjectsClassesAndCollections_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Phonebook_11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String,String> phonebook = new HashMap<String,String>();

        fillMap(phonebook,br);

        searchForContact(phonebook,br);
    }

    private static void searchForContact(Map<String, String> phonebook, BufferedReader br) throws IOException {
        String contact = br.readLine();
        while (contact != null && !contact.equalsIgnoreCase("Stop") && !phonebook.isEmpty()) {
            if(phonebook.containsKey(contact)){
              String phoneNumber = phonebook.get(contact);
                printContactAndNumber(contact,phoneNumber);
            }else {
                printContactDoesNotExists(contact);
            }
            contact = br.readLine();
        }
    }

    private static void printContactDoesNotExists(String contact) {
        System.out.printf("Contact %s does not exist.%n", contact);
    }

    private static void printContactAndNumber(String contact, String phoneNumber) {
        System.out.printf("%s -> %s%n", contact, phoneNumber);
    }


    private static void fillMap(Map<String, String> phonebook, BufferedReader br) throws IOException {
        String inputLine = br.readLine();
        while (!inputLine.equals("search")){
            String[] contact = inputLine.split("-");
            String name = contact [0];
            String number = contact [1];

            //add name and number to the contact
            phonebook.put(name,number);

            //update input
            inputLine = br.readLine();
        }
    }
}
