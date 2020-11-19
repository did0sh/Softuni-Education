package p02_ContainsEmployee;

import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class Engine implements Runnable{
    private final EntityManager entityManager;


    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void run(){
       this.containsEmployee();
    }

    private void containsEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee full name: ");
        String employeeName = scanner.nextLine();

        try {
            List<Employee> employees =
                    this.entityManager.createQuery("SELECT emp FROM Employee emp", Employee.class)
                            .getResultList();

            this.entityManager.getTransaction().begin();

            for (Employee e : employees) {
                String employeeFullName = e.getFirstName().concat(" ").concat(e.getLastName());
                if (employeeFullName.equals(employeeName)){
                    System.out.println("Yes");
                    return;
                }
            }

            System.out.println("No");

            this.entityManager.getTransaction().commit();
        } catch (Exception e){
            this.entityManager.getTransaction().rollback();
        }
    }
}
