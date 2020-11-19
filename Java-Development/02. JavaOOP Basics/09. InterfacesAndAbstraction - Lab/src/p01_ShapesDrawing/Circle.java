package p01_ShapesDrawing;

public class Circle implements Drawable {
    private Integer radius;
    private Integer width;
    private Integer height;


    public Circle(Integer radius, Integer width, Integer height) {
        this.radius = radius;
        this.width = width;
        this.height = height;
    }

    public Integer getRadius() {
        return this.radius;
    }

    @Override
    public void draw() {
        double radiusIn = this.getRadius() - 0.4;
        double radiusOut = this.getRadius() + 0.4;

        for (double y = this.getRadius(); y >= -this.getRadius() ; --y) {
            for (double x = -this.getRadius(); x < radiusOut ; x = x + 0.5) {
                double value = x * x + y * y;
                if (value >= radiusIn * radiusIn && value <= radiusOut * radiusOut){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
