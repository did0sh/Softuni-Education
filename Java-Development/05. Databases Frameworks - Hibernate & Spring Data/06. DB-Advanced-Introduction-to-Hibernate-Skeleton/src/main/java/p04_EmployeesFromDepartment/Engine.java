package p04_EmployeesFromDepartment;

import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class Engine implements Runnable{
    private final EntityManager entityManager;


    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void run(){
       this.findEmployeesFromDepartment();
    }

    private void findEmployeesFromDepartment(){
        try {
            List<Employee> employees =
                    this.entityManager.createQuery("SELECT emp FROM Employee emp " +
                                    "WHERE emp.department.name = 'Research and Development'" +
                                    "ORDER BY emp.salary, emp.id",
                            Employee.class)
                            .getResultList();

            this.entityManager.getTransaction().begin();

            for (Employee e : employees) {
                System.out.println(String.format("%s %s from %s - $%.2f", e.getFirstName(), e.getLastName(),
                        e.getDepartment().getName(), e.getSalary()));
            }

            this.entityManager.getTransaction().commit();
        } catch (Exception e){
            this.entityManager.getTransaction().rollback();
        }
    }
}
