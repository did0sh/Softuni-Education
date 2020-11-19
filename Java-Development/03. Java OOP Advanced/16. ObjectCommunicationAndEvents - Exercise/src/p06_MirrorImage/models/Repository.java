package p06_MirrorImage.models;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<Wizard> wizards;

    public Repository() {
        this.wizards = new ArrayList<>();
    }

    public void addWizard(Wizard wizard) {
        wizard.setId(this.wizards.size());
        this.wizards.add(wizard);
    }

    public Wizard getWizardById(int id) {
        return this.wizards.get(id);
    }
}
