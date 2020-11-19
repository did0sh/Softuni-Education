package p08_CustomListSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomListImpl<T extends Comparable<T>> implements CustomList<T> {
    private List<T> list;

    public CustomListImpl() {
        this.list = new ArrayList<>();
    }

    private boolean isAValidIndex(int index){
        if (index >= 0 && index <= this.list.size() - 1){
            return true;
        }

        return false;
    }

    protected List<T> getList() {
        return this.list;
    }

    @Override
    public void add(T element) {
        this.list.add(element);
    }

    @Override
    public T remove(int index) {
        if (isAValidIndex(index)){
            return this.list.remove(index);
        }

        throw new IllegalArgumentException("Index not valid.");
    }

    @Override
    public boolean contains(T element) {
        return this.list.contains(element);
    }

    @Override
    public void swap(int firstIndex, int secondIndex) {
        if (isAValidIndex(firstIndex) && isAValidIndex(secondIndex)){
            T tempElement = this.list.get(firstIndex);
            this.list.set(firstIndex, this.list.get(secondIndex));
            this.list.set(secondIndex, tempElement);
        } else {
            throw new IllegalArgumentException("Index not valid.");
        }

    }

    @Override
    public int countGreaterThan(T element) {
        int count = 0;
        for (T listItem : list) {
            if (listItem.compareTo(element) > 0){
                count++;
            }
        }

        return count;
    }

    @Override
    public T getMax() {
        return Collections.max(this.list);
    }

    @Override
    public T getMin() {
        return Collections.min(this.list);
    }

    @Override
    public void print(){
        this.list.forEach(System.out::println);
    }
}
