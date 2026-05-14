package Models;

import Interfaces.Tweetable;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.naming.OperationNotSupportedException;

public class MicrowaveOvenClientTest {

    public static final String TWEET = "Looking for a job";
    public static final String EMPTY_TWEET = "";

    @Test
    public void testReceiveTweet() throws OperationNotSupportedException {
        MicrowaveOvenClient client = new MicrowaveOvenClient();

        Tweetable tweetable = Mockito.mock(Tweetable.class);
        Mockito.when(tweetable.tweeterMessage()).thenReturn(TWEET);

        client.receiveTweet(tweetable);

        Assert.assertEquals(TWEET, tweetable.tweeterMessage());
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testReceiveTweetNull() throws OperationNotSupportedException {
        MicrowaveOvenClient client = new MicrowaveOvenClient();

        Tweetable tweetable = Mockito.mock(Tweetable.class);
        Mockito.when(tweetable.tweeterMessage()).thenReturn(null);
        client.receiveTweet(tweetable);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testReceiveTweetEmpty() throws OperationNotSupportedException {
        MicrowaveOvenClient client = new MicrowaveOvenClient();

        Tweetable tweetable = Mockito.mock(Tweetable.class);
        Mockito.when(tweetable.tweeterMessage()).thenReturn(EMPTY_TWEET);
        client.receiveTweet(tweetable);
    }
}