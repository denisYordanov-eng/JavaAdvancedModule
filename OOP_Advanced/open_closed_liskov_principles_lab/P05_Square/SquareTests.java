package P05_Square;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class SquareTests {
    @Test
    public  void  getRectangleTest() throws OperationNotSupportedException {
        Rectangle square = new Square(5,5);
        Assert.assertEquals(25, square.getArea());
    }

    @Test(expected=OperationNotSupportedException.class)
    public void getSquareSidesDifferentValuesTest() throws OperationNotSupportedException {
        Rectangle square = new Square(5,4);
    }

    @Test
    public void calculateAreaTest() throws OperationNotSupportedException {
        Rectangle square = new Square(5,5);
        Assert.assertEquals(25, square.getArea());
    }
}
