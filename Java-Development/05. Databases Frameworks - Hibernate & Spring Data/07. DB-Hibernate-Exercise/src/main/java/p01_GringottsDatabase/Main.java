package p01_GringottsDatabase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("gringotts");
        EntityManager entityManager = factory.createEntityManager();

        WizardDeposit deposit = new WizardDeposit();
        deposit.setFirstName("Ivan");
        deposit.setLastName("Ivanov");
        deposit.setAge(23);
        deposit.setDepositStartDate(new Date());
        deposit.setDepositAmount(1024.52);
        deposit.setMagicWandCreator("Pesho Peshov");
        deposit.setNotes("This is a test for the database");

        entityManager.getTransaction().begin();

        entityManager.persist(deposit);

        entityManager.getTransaction().commit();
    }
}
