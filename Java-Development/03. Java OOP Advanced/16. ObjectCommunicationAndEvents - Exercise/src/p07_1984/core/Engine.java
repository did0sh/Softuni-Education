package p07_1984.core;

import p07_1984.interfaces.Observer;
import p07_1984.models.Company;
import p07_1984.models.Employee;
import p07_1984.models.Entity;
import p07_1984.models.Institution;
import p07_1984.repositories.EntityRepository;
import p07_1984.repositories.ObserverRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {

    private BufferedReader reader;
    private ObserverRepository observerRepository;
    private EntityRepository entityRepository;

    public Engine(ObserverRepository observerRepository, EntityRepository entityRepository) {
        this.observerRepository = observerRepository;
        this.entityRepository = entityRepository;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() throws IOException {
        String[] tokens = this.reader.readLine().split("\\s+");
        int entitiesCount = Integer.parseInt(tokens[0]);
        int institutionsCount = Integer.parseInt(tokens[1]);
        int changesCount = Integer.parseInt(tokens[2]);
        for (int i = 0; i < entitiesCount; i++) {
            tokens = this.reader.readLine().split("\\s+");
            String type = tokens[0];
            String id = tokens[1];
            String name = tokens[2];
            Entity entity;
            if (type.equals("Employee")) {
                int income = Integer.parseInt(tokens[3]);
                entity = new Employee(id, name, income);
            } else {
                int turnover = Integer.parseInt(tokens[3]);
                int revenue = Integer.parseInt(tokens[4]);
                entity = new Company(id, name, turnover, revenue);
            }
            this.entityRepository.addEntity(entity);
        }

        for (int i = 0; i < institutionsCount; i++) {
            tokens = this.reader.readLine().split("\\s+");
            String id = tokens[1];
            String name = tokens[2];
            Observer observer = new Institution(id, name);
            for (int j = 3; j < tokens.length; j++) {
                observer.addSubject(tokens[j]);
            }
            this.observerRepository.addObserver(observer);
            for (Entity entity : this.entityRepository.getAllEntities()) {
                entity.attachObserver(observer);
            }
        }


        for (int i = 0; i < changesCount; i++) {
            tokens = this.reader.readLine().split("\\s+");
            String id = tokens[0];
            Entity entity = this.entityRepository.getById(id);
            String fieldName = tokens[1];
            Object newValue = tokens[2];
            entity.update(fieldName, newValue);
        }

        for (Observer observer : this.observerRepository.getAllObservers()) {
            System.out.println(observer);
            observer.printLogs();
        }
    }
}