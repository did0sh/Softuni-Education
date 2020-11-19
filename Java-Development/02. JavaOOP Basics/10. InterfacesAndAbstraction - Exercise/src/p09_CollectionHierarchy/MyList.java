package p09_CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class MyList implements Addable,Removable {
    private List<String> list;
    private int used;

    public MyList() {
        this.list = new ArrayList<>();
    }

    public int getUsed() {
        this.used = this.list.size();
        return this.used;
    }

    @Override
    public int add(String element) {
        int index = 0;
        this.list.add(index, element);
        return index;
    }

    @Override
    public String remove(){
        int index = 0;
        return this.list.remove(index);
    }
}
