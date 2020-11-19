package p08_FindLatest10Projects;

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
        this.findLatest10Projects();
    }

    private void findLatest10Projects() {
        StringBuilder sb = new StringBuilder();

        try {
            this.entityManager.getTransaction().begin();

            List<Project> projects = this.entityManager.createQuery("SELECT pr FROM Project pr " +
                            "ORDER BY pr.startDate DESC",
                    Project.class)
                    .setMaxResults(10)
                    .getResultList();

            projects.stream().sorted(Comparator.comparing(Project::getName))
                    .forEach(pr -> sb.append(String.format("Project name: %s%n" +
                    "\tProject Description: %s%n" +
                    "\tProject Start Date:%s%n" +
                    "\tProject End Date: %s%n", pr.getName(), pr.getDescription(), pr.getStartDate(), pr.getEndDate())));

            System.out.print(sb.toString());

            this.entityManager.getTransaction().commit();

        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        }
    }
}
