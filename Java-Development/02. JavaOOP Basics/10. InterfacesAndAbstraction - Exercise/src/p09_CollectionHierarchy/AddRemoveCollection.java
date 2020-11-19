package p09_CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class AddRemoveCollection implements Addable,Removable {
    private List<String> list;

    public AddRemoveCollection() {
        this.list = new ArrayList<>();
    }

    @Override
    public int add(String element) {
        int index = 0;
        this.list.add(index, element);
        return index;
    }

    @Override
    public String remove(){
        int index = this.list.size() - 1;
        return this.list.remove(index);
    }

}
