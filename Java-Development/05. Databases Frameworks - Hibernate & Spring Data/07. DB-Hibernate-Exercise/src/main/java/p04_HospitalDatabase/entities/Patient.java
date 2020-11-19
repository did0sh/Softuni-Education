package p04_HospitalDatabase.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient {
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private Date dateOfBirth;
    private byte[] picture;
    private boolean isMedicallyInsured;
    private Set<Visitation> visitations;
    private Set<Medicament> medicaments;
    private Set<Diagnose> diagnoses;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", length = 30, nullable = false)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", length = 30, nullable = false)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "address", length = 50, nullable = false)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "email", length = 30)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "date_of_birth")
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "picture")
    public byte[] getPicture() {
        return this.picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Column(name = "has_insurance")
    public boolean isMedicallyInsured() {
        return this.isMedicallyInsured;
    }

    public void setMedicallyInsured(boolean medicallyInsured) {
        isMedicallyInsured = medicallyInsured;
    }

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    public Set<Visitation> getVisitations() {
        return this.visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "patients_medicaments",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medicament_id", referencedColumnName = "id")
    )
    public Set<Medicament> getMedicaments() {
        return this.medicaments;
    }

    public void setMedicaments(Set<Medicament> medicaments) {
        this.medicaments = medicaments;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "patients_diagnoses",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "diagnose_id", referencedColumnName = "id")
    )
    public Set<Diagnose> getDiagnoses() {
        return this.diagnoses;
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }
}
