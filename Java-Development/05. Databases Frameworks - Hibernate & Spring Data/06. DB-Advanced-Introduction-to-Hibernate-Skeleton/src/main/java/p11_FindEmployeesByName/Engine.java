package p11_FindEmployeesByName;

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
        this.findEmployeesByPattern();
    }

    private void findEmployeesByPattern() {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();

        try {
            this.entityManager.getTransaction().begin();

           List<Employee> employees = this.entityManager.createQuery("SELECT emp FROM Employee emp " +
                   "WHERE emp.firstName LIKE :pattern",
                   Employee.class)
                   .setParameter("pattern", pattern + "%")
                   .getResultList();

            employees.forEach(employee -> sb.append(String.format("%s %s - %s - ($%.2f)%n", employee.getFirstName(),
                    employee.getLastName(), employee.getJobTitle(), employee.getSalary())));

            this.entityManager.getTransaction().commit();

            System.out.print(sb.toString());

        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        }
    }
}
