package p01_RemoveObjects;

import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;

public class Engine implements Runnable{
    private final EntityManager entityManager;


    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void run(){
       this.removeObjects();
    }

    private void removeObjects(){
        try {
            List<Town> towns =
                    this.entityManager.createQuery("SELECT t FROM Town t", Town.class)
                            .getResultList();

            for (Town town:towns) {
                if (town.getName().length() > 5){
                    this.entityManager.detach(town);
                }
            }

            this.entityManager.getTransaction().begin();

            for (Town town:towns) {
                if (this.entityManager.contains(town)){
                    System.out.print(town.getName() + " -> ");

                    town.setName(town.getName().toLowerCase());

                    System.out.println(town.getName());
                }
            }

            this.entityManager.getTransaction().commit();
        } catch (Exception e){
            this.entityManager.getTransaction().rollback();
        }
    }
}
