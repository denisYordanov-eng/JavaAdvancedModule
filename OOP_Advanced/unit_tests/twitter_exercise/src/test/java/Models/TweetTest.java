package Models;


import Interfaces.Tweetable;
import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;


import javax.naming.OperationNotSupportedException;


public class TweetTest  {
    public static final String TWEET = "Looking for a job";

    @Test(expected = OperationNotSupportedException.class)
    public void testTweet() throws OperationNotSupportedException {
        Tweetable tweetable = new Tweet("");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testTweetNullMessage() throws OperationNotSupportedException {
        Tweetable tweetable = new Tweet(null);
    }
    @Test()
    public void testTweeterMessage() throws OperationNotSupportedException {
        Tweetable tweetable = new Tweet(TWEET);
        Assert.assertEquals(TWEET, tweetable.tweeterMessage());
    }


}