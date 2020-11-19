package p04_Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private List<Integer> items;

    public Lake(Integer... items) {
        this.items = Arrays.asList(items);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer>{

        private int index;

        Frog() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return items.size() > this.index;
        }

        @Override
        public Integer next() {
            this.index += 2;
            int element = items.get(this.index - 2);
            if (this.index % 2 == 0 && this.index >= items.size()){
                this.index = 1;
            }
            return element;
        }
    }
}
