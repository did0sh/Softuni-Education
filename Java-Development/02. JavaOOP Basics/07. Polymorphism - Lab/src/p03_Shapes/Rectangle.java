package p03_Shapes;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    protected double calculatePerimeter() {
        return 2*(this.width + this.height);
    }

    @Override
    protected double calculateArea() {
        return this.width * this.height;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }
}
