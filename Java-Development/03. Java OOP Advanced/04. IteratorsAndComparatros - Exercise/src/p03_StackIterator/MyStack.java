package p03_StackIterator;

import java.util.*;

public class MyStack implements Iterable<Integer> {
    private List<Integer> items;

    public MyStack() {
        this.items = new ArrayList<>();
    }

    public final void push(Integer... elements){
       this.items.addAll(Arrays.asList(elements));
    }

    public void pop(){
        if (this.items.isEmpty()){
            throw new NoSuchElementException("No elements");
        }
        this.items.remove(this.items.size() - 1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<Integer>{

        int counter;

        StackIterator() {
            this.counter = items.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return this.counter >= 0;
        }

        @Override
        public Integer next() {
            return items.get(this.counter--);
        }
    }
}
