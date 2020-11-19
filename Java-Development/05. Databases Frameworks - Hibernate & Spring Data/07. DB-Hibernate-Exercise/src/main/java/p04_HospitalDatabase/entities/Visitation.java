package p04_HospitalDatabase.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visitations")
public class Visitation {
    private long id;
    private Date visitationDate;
    private String comments;
    private Patient patient;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "visitation_date")
    public Date getVisitationDate() {
        return this.visitationDate;
    }

    public void setVisitationDate(Date visitationDate) {
        this.visitationDate = visitationDate;
    }

    @Column(name = "comments", length = 3000, nullable = false)
    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @ManyToOne
    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
