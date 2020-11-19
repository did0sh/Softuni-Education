package p01_ListyIterator;


import java.util.List;

public class ListyIterator {

    private List<String> items;
    private int index;

    public ListyIterator(List<String> items) {
        this.items = items;
    }

    public boolean move(){
        if(this.index + 1 < this.items.size()){
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext(){
        return this.index < this.items.size() - 1;
    }

    public void print(){
        if (this.items.isEmpty()){
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(this.items.get(this.index));
    }
}
