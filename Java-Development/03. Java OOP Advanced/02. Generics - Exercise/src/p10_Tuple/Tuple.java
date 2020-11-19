package p10_Tuple;

public class Tuple<I1, I2> {
    private I1 firstItem;
    private I2 secondItem;


    public Tuple(I1 firstItem, I2 secondItem) {
        this.setFirstItem(firstItem);
        this.setSecondItem(secondItem);
    }

    private void setFirstItem(I1 firstItem) {
        this.firstItem = firstItem;
    }

    private void setSecondItem(I2 secondItem) {
        this.secondItem = secondItem;
    }

    public I1 getFirstItem() {
        return this.firstItem;
    }

    public I2 getSecondItem() {
        return this.secondItem;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s -> %s%n", this.getFirstItem(), this.getSecondItem()));
        return sb.toString();
    }
}
