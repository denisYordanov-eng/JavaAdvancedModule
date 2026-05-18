package P05_Square;

import org.junit.Assert;
import org.junit.Test;



public class RectangleTests {
    @Test
    public void getSidesTest() {
        Rectangle rect = new Rectangle(5,10);

        Assert.assertEquals(10, rect.getHeight());
        Assert.assertEquals(5, rect.getWidth());
    }

    @Test
    public void getAreaTest() {
        Rectangle rect = new Rectangle(5,10);
        Assert.assertEquals(50, rect.getArea());
    }



}
