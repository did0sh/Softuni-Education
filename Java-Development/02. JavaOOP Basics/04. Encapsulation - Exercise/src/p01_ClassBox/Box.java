package p01_ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    private double calcSurfaceArea(){
        return 2*(this.length * this.width + this.length * this.height + this.width * this.height);
    }

    private double calcLateralSurfaceArea(){
        return 2*(this.length * this.height + this.width * this.height);
    }

    private double calcVolume(){
        return this.length * this.width * this.height;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Surface Area - %.2f%n", calcSurfaceArea()))
            .append(String.format("Lateral Surface Area - %.2f%n", calcLateralSurfaceArea()))
            .append(String.format("Volume - %.2f", calcVolume()));

        return sb.toString();
    }
}
