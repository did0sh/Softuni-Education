package p11_Threeuple;

public class Threeuple<E1, E2, E3> {
    private E1 firstItem;
    private E2 secondItem;
    private E3 thirdItem;

    public Threeuple(E1 firstItem, E2 secondItem, E3 thirdItem) {
        this.setFirstItem(firstItem);
        this.setSecondItem(secondItem);
        this.setThirdItem(thirdItem);
    }

    private void setFirstItem(E1 firstItem) {
        this.firstItem = firstItem;
    }

    private void setSecondItem(E2 secondItem) {
        this.secondItem = secondItem;
    }

    private void setThirdItem(E3 thirdItem) {
        this.thirdItem = thirdItem;
    }

    public E1 getFirstItem() {
        return this.firstItem;
    }

    public E2 getSecondItem() {
        return this.secondItem;
    }

    public E3 getThirdItem() {
        return this.thirdItem;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s -> %s -> %s%n", this.getFirstItem(), this.getSecondItem(),
                this.getThirdItem()));
        return sb.toString();
    }
}
