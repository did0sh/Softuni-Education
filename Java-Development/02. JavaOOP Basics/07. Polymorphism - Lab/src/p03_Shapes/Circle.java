package p03_Shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    protected double calculatePerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    protected double calculateArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public final double getRadius() {
        return this.radius;
    }
}
