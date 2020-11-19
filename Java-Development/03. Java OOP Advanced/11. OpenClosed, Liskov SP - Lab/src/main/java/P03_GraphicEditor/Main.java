package P03_GraphicEditor;

public class Main {
    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();

        Drawable circle = new Circle();
        Drawable shape = new Shape();
        Drawable rectangle = new Rectangle();

        editor.drawShape(circle);
        editor.drawShape(shape);
        editor.drawShape(rectangle);
    }
}
