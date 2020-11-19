package p06_AddressesWithEmployeeCount;

import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class Engine implements Runnable {
    private final EntityManager entityManager;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void run() {
        this.findAddresses();
    }

    private void findAddresses() {
        StringBuilder sb = new StringBuilder();

        try {
            this.entityManager.getTransaction().begin();

            this.entityManager.createQuery("SELECT adr FROM Address adr " +
                            "ORDER BY adr.employees.size DESC, adr.town.id",
                    Address.class)
                    .setMaxResults(10)
                    .getResultList()
                    .forEach(adr -> sb.append(String.format("%s, %s - %d employees%n",
                            adr.getText(), adr.getTown().getName(), adr.getEmployees().size())));


            System.out.print(sb.toString());

            this.entityManager.getTransaction().commit();

        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        }
    }
}
