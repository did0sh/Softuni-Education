package p09_IncreaseSalaries;

import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class Engine implements Runnable {
    private final EntityManager entityManager;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void run() {
        this.increaseSalaries();
    }

    private void increaseSalaries() {
        StringBuilder sb = new StringBuilder();

        try {
            this.entityManager.getTransaction().begin();

            List<Employee> employees = this.entityManager.createQuery("SELECT em FROM Employee em " +
                            "WHERE em.department.name IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services')",
                    Employee.class)
                    .getResultList();

            employees.forEach(employee -> employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.12))));

            employees.forEach(employee -> sb.append(String.format("%s %s ($%.2f)%n",
                    employee.getFirstName(), employee.getLastName(), employee.getSalary())));

            this.entityManager.getTransaction().commit();
            System.out.print(sb.toString());


        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        }
    }
}
