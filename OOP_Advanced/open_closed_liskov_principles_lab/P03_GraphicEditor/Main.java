package P03_GraphicEditor;

public class Main {
    public static void main(String[] args) {
        Drawabe circle = new Circle();
        Drawabe rectangle = new Rectangle();
        Drawabe shape =  new Shape();

        GraphicEditor editor = new GraphicEditor();
        editor.drawShape(circle);
        editor.drawShape(rectangle);
        editor.drawShape(shape);
    }
}
