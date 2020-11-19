package p08_CustomListSorter;

public interface CustomList<T> {
    void add(T element);

	T remove(int index);

	boolean contains(T element);

	void swap(int firstIndex, int secondIndex);

	int countGreaterThan(T element);

	T getMax();

	T getMin();

	void print();
}
