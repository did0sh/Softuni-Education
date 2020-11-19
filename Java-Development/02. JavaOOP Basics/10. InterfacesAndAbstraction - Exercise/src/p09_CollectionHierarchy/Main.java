package p09_CollectionHierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] items = reader.readLine().split("\\s+");
        Addable addCollection = new AddCollection();
        Addable addRemoveCollection = new AddRemoveCollection();
        Addable myList = new MyList();

        addItems(addCollection, items);
        addItems(addRemoveCollection, items);
        addItems(myList, items);

        int removeOperations = Integer.parseInt(reader.readLine());

        removeItems((Removable) addRemoveCollection, removeOperations);
        removeItems((Removable) myList, removeOperations);
    }

    private static void removeItems(Removable removable, int removeOperations) {
        for (int i = 0; i < removeOperations; i++) {
            System.out.printf("%s ",removable.remove());
        }
        System.out.println();
    }

    private static void addItems(Addable collection, String[] items){
        for (String item : items) {
            System.out.printf("%d ", collection.add(item));
        }
        System.out.println();
    }
}
