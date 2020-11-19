package P05_Square;

import sun.plugin.dom.exception.InvalidStateException;

public class Main {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(10, 5);
        Square square = null;

        try {
            square = new Square(10, 7);
        }catch (InvalidStateException ise){
            System.out.println(ise.getMessage());
        }

        if (square == null){
            square = new Square(10, 10);
        }

        System.out.println(rect.getArea());
        System.out.println(square.getArea());
    }
}
