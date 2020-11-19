package P05_Square;

import sun.plugin.dom.exception.InvalidStateException;

public class Square extends Rectangle {
    public Square(int width, int height) {
        this.validate(width,height);
        super.setHeight(height);
        super.setWidth(width);
    }

    private void validate(int width, int height){
        if (width != height){
            throw new InvalidStateException("Square sides must be equal");
        }
    }
}
