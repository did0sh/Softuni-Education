package p04_HospitalDatabase;

import p04_HospitalDatabase.entities.Diagnose;
import p04_HospitalDatabase.entities.Medicament;
import p04_HospitalDatabase.entities.Patient;
import p04_HospitalDatabase.entities.Visitation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.HashSet;

public class HospitalDemo {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hospital");
        EntityManager entityManager = factory.createEntityManager();

        Diagnose diagnose = new Diagnose();
        diagnose.setName("Cold");
        diagnose.setComments("High temperature, needs lots of fluids");
        diagnose.setPatients(new HashSet<>());

        Diagnose diagnose2 = new Diagnose();
        diagnose2.setName("Mindless");
        diagnose2.setComments("It`s a joke");
        diagnose2.setPatients(new HashSet<>());

        Medicament medicament = new Medicament();
        medicament.setName("Fervex");
        medicament.setPatients(new HashSet<>());

        Medicament medicament2 = new Medicament();
        medicament2.setName("Strepsils");
        medicament2.setPatients(new HashSet<>());

        Visitation visitation = new Visitation();
        visitation.setVisitationDate(new Date());
        visitation.setComments("Tommorow I will not be working");

        Visitation visitation2 = new Visitation();
        visitation2.setVisitationDate(new Date());
        visitation2.setComments("I am here");

        Patient patient = new Patient();
        patient.setFirstName("Pesho");
        patient.setLastName("Peshev");
        patient.setAddress("Street g.Mihalev");
        patient.setMedicallyInsured(true);

        patient.setDiagnoses(new HashSet<Diagnose>()
        {{
            add(diagnose); add(diagnose2);
        }});

        patient.setMedicaments(new HashSet<Medicament>()
        {{
            add(medicament); add(medicament2);
        }});

        patient.setVisitations(new HashSet<Visitation>()
        {{
            add(visitation); add(visitation2);
        }});

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(patient);

            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            ex.printStackTrace();
        }
    }
}
