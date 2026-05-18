package P05_Square;

import javax.naming.OperationNotSupportedException;

public class Square extends Rectangle {

    public Square(int width, int height) throws OperationNotSupportedException {
        super(width, width);
        if(width != height) {
            throw new OperationNotSupportedException("The width and height of the rectangles do not match");
        }
    }


}
