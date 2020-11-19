package p01_ShapesDrawing.models;

import p01_ShapesDrawing.contracts.Drawable;

public class Rectangle implements Drawable {
    private Integer width;
    private Integer height;

    public Rectangle(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        for (int i = 0; i < height; i++) {
            System.out.print("*");
            for (int k = 1; k < width - 1; k++) {
                System.out.print(" ");
                if (i == 0 || i == (height - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print(" "); System.out.print("*");
            System.out.print("\n");
        }
    }
}
