package DefiningClass_Exercises.cat_lady;

public class Siamese  extends BaseCat {
private  double earSize;

    public Siamese(String name, String type, double earSize) {
        super(name, type);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f",super.toString(),this.earSize);
    }
}
