package StringProcessing_Lab;

import java.util.Scanner;

public class ParseUrl_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String input = scanner.nextLine().trim();

            if (input.indexOf("://") != input.lastIndexOf("://")) {
                System.out.println("Invalid URL");
                return;
            }
            String[] url = input.split("://");
            if (url.length != 2) {
                System.out.println("Invalid URL");
                return;
            }

            String protocol = url[0];

            if (!url[1].contains("/")) {
                System.out.println("Invalid URL");
                return;
            }
            if (url[1].contains("://")) {
                System.out.println("Invalid URL");
                return;
            }
            String server = url[1].substring(0, url[1].indexOf('/'));

            String resource = url[1].substring(url[1].indexOf('/') + 1);

            if (server.isEmpty() || resource.isEmpty() || protocol.isEmpty()) {
                System.out.println("Invalid URL");
                return;
            }

            printOutput(protocol, server, resource);
        }
        catch (Exception e){
            System.out.println("Invalid URL");
        }
    }

    private static void printOutput(String protocol, String server, String resource) {
        System.out.printf("Protocol = %s%n", protocol);
        System.out.printf("Server = %s%n", server);
        System.out.printf("Resources = %s%n", resource);
    }
}
