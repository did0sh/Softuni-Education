package p05_AddingANewAddressAndUpdatingEmployee;

import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class Engine implements Runnable {
    private final EntityManager entityManager;


    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void run() {
        this.addAddressUpdateEmployee();
    }

    private void addAddressUpdateEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee last name: ");
        String lastName = scanner.nextLine();
        try {
            Employee employee =
                    this.entityManager.createQuery("SELECT emp FROM Employee emp WHERE emp.lastName = :lastName",
                            Employee.class)
                            .setParameter("lastName", lastName)
                            .getSingleResult();

            Town sofia =
                    this.entityManager.createQuery("SELECT t FROM Town t WHERE t.name = 'sofia'", Town.class)
                            .getSingleResult();

            Address address = new Address();
            address.setText("Vitoshka 15");
            address.setTown(sofia);

            this.entityManager.getTransaction().begin();

            this.entityManager.persist(address);

            employee.setAddress(address);

            this.entityManager.getTransaction().commit();

            System.out.println(String.format("%s %s changed address to %s, %s", employee.getFirstName(), employee.getLastName(),
                    employee.getAddress().getText(), employee.getAddress().getTown().getName()));

        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        }
    }
}
