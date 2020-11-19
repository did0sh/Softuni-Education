package p09_CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class AddCollection implements Addable {
    private List<String> list;

    public AddCollection() {
        this.list = new ArrayList<>();
    }

    @Override
    public int add(String element) {
        if (this.list.size() == 0){
            this.list.add(0, element);
            return 0;
        }

        int index = this.list.size();
        this.list.add(index, element);
        return index;
    }
}
