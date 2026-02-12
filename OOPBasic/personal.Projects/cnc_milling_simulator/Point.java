package cnc_milling_simulator;

public class Point {
    private static final double MACHINE_MAX_X = 500;

    private static final double MACHINE_MAX_Y = 200;

    private static final double MACHINE_MAX_Z = 200;

    private  double x;

    private  double y;

    private  double z;

    public Point(double x, double y, double z) {
        setX(x);
        setY(y);
        setZ(z);
    }

     double getX() {
        return x;
    }

     double getY() {
        return y;
    }

     double getZ() {
        return z;
    }

    private void setX(double x) {
      if(x > MACHINE_MAX_X || x < -MACHINE_MAX_X) {
          throw new IllegalArgumentException("Invalid coordinates on X axis!");
      }
      this.x = x;
    }

    private void setY(double y) {
        if(y > MACHINE_MAX_Y || y < -MACHINE_MAX_Y){
            throw new IllegalArgumentException("Invalid coordinates on Y axis!");
        }
        this.y = y;
    }

    private void setZ(double z) {
        if(z > MACHINE_MAX_Z || z < -MACHINE_MAX_Z){
            throw new IllegalArgumentException("Invalid coordinates on Z axis!");
        }
        this.z = z;
    }
}
