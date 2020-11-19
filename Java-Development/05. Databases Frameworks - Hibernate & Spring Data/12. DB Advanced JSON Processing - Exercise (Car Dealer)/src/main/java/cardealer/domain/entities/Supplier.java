package cardealer.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "suppliers")
public class Supplier extends BaseEntity {

    private String name;
    private boolean isImporter;
    private List<Part> parts;

    public Supplier() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "is_importer", nullable = false)
    public boolean isImporter() {
        return this.isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }

    @OneToMany(targetEntity = Part.class, mappedBy = "supplier", fetch = FetchType.EAGER)
    public List<Part> getParts() {
        return this.parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }
}
