package p03_EmployeesWithSalaryOver50000;

import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class Engine implements Runnable{
    private final EntityManager entityManager;


    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void run(){
       this.findEmployeesWithSalaryMoreThan50000();
    }

    private void findEmployeesWithSalaryMoreThan50000(){
        try {
            List<Employee> employees =
                    this.entityManager.createQuery("SELECT emp FROM Employee emp WHERE emp.salary > 50000",
                            Employee.class)
                            .getResultList();

            this.entityManager.getTransaction().begin();

            for (Employee e : employees) {
                System.out.println(e.getFirstName());
            }

            this.entityManager.getTransaction().commit();
        } catch (Exception e){
            this.entityManager.getTransaction().rollback();
        }
    }
}
