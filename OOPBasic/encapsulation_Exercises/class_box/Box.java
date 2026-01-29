package encapsulation_exercise.class_box;

public class Box {
    private double length;

    private double width;

    private double height;


    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double calculateSurfaceArea() {
        //Surface Area = 2lw + 2lh + 2wh
        return (2 * this.length * this.width) + (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    public double calculateVolumeArea() {
        //Volume = lwh
        return  this.length * this.width * this.height;
    }

    public double calculateLateralSurfaceArea () {
        //Lateral Surface Area = 2lh + 2wh
        return (2 * this.length * this.height) + (2 * this.width * this.height);
    }
}
