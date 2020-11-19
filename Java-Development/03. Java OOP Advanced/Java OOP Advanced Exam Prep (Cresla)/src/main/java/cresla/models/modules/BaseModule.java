package cresla.models.modules;

import cresla.interfaces.Module;

public abstract class BaseModule implements Module {
    private int id;

    BaseModule(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
