package p04_HospitalDatabase.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "diagnoses")
public class Diagnose {
    private long id;
    private String name;
    private String comments;
    private Set<Patient> patients;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", length = 50, nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "comments", length = 3000, nullable = false)
    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @ManyToMany(mappedBy = "diagnoses")
    public Set<Patient> getPatients() {
        return this.patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
