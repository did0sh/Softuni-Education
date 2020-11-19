package p02_ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public void setLength(double length) {
        if (length <= 0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    public void setWidth(double width) {
        if (width <= 0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
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
