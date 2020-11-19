package p07_GetEmployeeWithProject;

import entities.Address;
import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Engine implements Runnable {
    private final EntityManager entityManager;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void run() {
        this.printEmployee();
    }

    private void printEmployee() {
        Scanner scan = new Scanner(System.in);
        int employeeId = Integer.parseInt(scan.nextLine());
        StringBuilder sb = new StringBuilder();

        try {
            this.entityManager.getTransaction().begin();

            Employee employee = this.entityManager.createQuery("SELECT emp FROM Employee emp " +
                            "WHERE emp.id = :id",
                    Employee.class)
                    .setParameter("id", employeeId)
                    .getSingleResult();

            sb.append(String.format("%s %s - %s%n",
                    employee.getFirstName(), employee.getLastName(), employee.getJobTitle()));

            employee.getProjects().stream()
                    .sorted(Comparator.comparing(Project::getName))
                    .forEach(pr -> sb.append(String.format("    %s%n", pr.getName())));

            System.out.print(sb.toString());

            this.entityManager.getTransaction().commit();

        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        }
    }
}
