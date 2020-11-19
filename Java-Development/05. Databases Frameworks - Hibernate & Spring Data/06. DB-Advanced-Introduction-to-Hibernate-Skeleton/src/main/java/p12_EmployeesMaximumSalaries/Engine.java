package p12_EmployeesMaximumSalaries;

import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Engine implements Runnable {
    private final EntityManager entityManager;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void run() {
        this.findEmployeesMaxSalary();
    }

    private void findEmployeesMaxSalary() {
        StringBuilder sb = new StringBuilder();

        try {
            this.entityManager.getTransaction().begin();

             this.entityManager.createQuery("SELECT e FROM Employee AS e " +
                    "WHERE e.salary NOT BETWEEN 30000 AND 70000 " +
                    "GROUP BY e.department " +
                    "ORDER BY e.salary DESC", Employee.class)
                    .getResultList()
                    .stream()
                    .sorted(Comparator.comparing(e -> e.getDepartment().getId()))
                    .forEach(employee -> sb.append(String.format("%s - %.2f%n",
                            employee.getDepartment().getName(), employee.getSalary())));

            this.entityManager.getTransaction().commit();

            System.out.print(sb.toString());

        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        }
    }
}
