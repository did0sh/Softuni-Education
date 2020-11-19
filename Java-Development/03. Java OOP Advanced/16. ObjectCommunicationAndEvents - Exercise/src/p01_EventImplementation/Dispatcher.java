package p01_EventImplementation;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private String name;
    private List<NameChangeListener> nameChangeListeners;

    public Dispatcher(String name) {
        this.name = name;
        this.nameChangeListeners = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addNameChangeListener(NameChangeListener changeListener){
        this.nameChangeListeners.add(changeListener);
    }

    public void removeNameChangeListener(NameChangeListener changeListener){
        if (this.nameChangeListeners.contains(changeListener)){
            this.nameChangeListeners.remove(changeListener);
        }
    }

    public void fireNameChangeListener(){
        this.nameChangeListeners.forEach(NameChangeListener::handleChangedName);
    }
}
