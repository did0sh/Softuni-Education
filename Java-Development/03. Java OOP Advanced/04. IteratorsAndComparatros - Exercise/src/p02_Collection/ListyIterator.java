package p02_Collection;


import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {

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

    public String printAll(){
        StringBuilder sb = new StringBuilder();
        this.items.forEach(item -> sb.append(item).append(" "));
        return sb.toString().trim();
    }

    @Override
    public Iterator<String> iterator() {
        return new CollectionIterator();
    }

    private final class CollectionIterator implements Iterator<String>{

        private int index;

        public CollectionIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return items.size() > this.index;
        }

        @Override
        public String next() {
            return items.get(this.index++);
        }
    }
}
