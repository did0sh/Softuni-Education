package p10_RemoveTowns;

import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Engine implements Runnable {
    private final EntityManager entityManager;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void run() {
        this.removeTowns();
    }

    private void removeTowns() {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        String townName = scanner.nextLine();

        try {
            this.entityManager.getTransaction().begin();

            Town town = this.entityManager.createQuery("SELECT t FROM Town t " +
                            "WHERE t.name = :townName",
                    Town.class)
                    .setParameter("townName", townName)
                    .getSingleResult();

           List<Address> addresses = this.entityManager.createQuery("SELECT adr FROM Address adr " +
                   "WHERE adr.town.name = :townName",
                   Address.class)
                   .setParameter("townName", townName)
                   .getResultList();

            sb.append(String.format("%d address%s in %s deleted%n", addresses.size(),
                    (addresses.size() != 1) ? "es" : "", town.getName()));

            addresses.forEach(address -> {
                for (Employee employee : address.getEmployees()) {
                    employee.setAddress(null);
                }
                address.setTown(null);
                entityManager.remove(address);
            });

            entityManager.remove(town);

            this.entityManager.getTransaction().commit();

            System.out.print(sb.toString());

        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        }
    }
}
