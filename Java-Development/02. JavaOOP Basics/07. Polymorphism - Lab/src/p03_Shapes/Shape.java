package p03_Shapes;

public abstract class Shape {
    private double perimeter;
    private double area;


    public double getPerimeter() {
        return this.perimeter;
    }

    public double getArea() {
        return this.area;
    }

    protected abstract double calculatePerimeter();
    protected abstract double calculateArea();
}
