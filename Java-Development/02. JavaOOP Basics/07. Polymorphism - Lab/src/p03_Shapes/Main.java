package p03_Shapes;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 5);
        Shape circle = new Circle(5);

        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());

        System.out.println(circle.calculateArea());
        System.out.println(circle.calculatePerimeter());
    }
}
