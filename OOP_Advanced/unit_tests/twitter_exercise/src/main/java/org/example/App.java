package org.example;

import Interfaces.Tweetable;
import Models.MicrowaveOvenClient;
import Models.Tweet;

import javax.naming.OperationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException, OperationNotSupportedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tweetable tweet = new Tweet(br.readLine());

        MicrowaveOvenClient client = new MicrowaveOvenClient();
        client.receiveTweet(tweet);
    }
}
