package p07_1984.models;

import p07_1984.interfaces.Observer;
import p07_1984.interfaces.Subject;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Entity implements Subject {

    private String id;
    private Set<Observer> observers;
    private String name;

    protected Entity(String id, String name) {
        this.id = id;
        this.name = name;
        this.observers = new LinkedHashSet<>();
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public <T, E> void update(T fieldName, E newValue) {
        Class<? extends Entity> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Field targetField = null;
        Object oldValue = null;
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equals(fieldName)) {
                try {
                    targetField = field;
                    oldValue = targetField.get(this);
                    break;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        if (targetField == null) {
            clazz = Entity.class;
            fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getName().equals(fieldName)) {
                    try {
                        targetField = field;
                        oldValue = targetField.get(this);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        try {
            try {
                targetField.setAccessible(true);
                try {
                    targetField.set(this, Integer.valueOf(newValue.toString()));
                } catch (Exception e) {
                    targetField.set(this, newValue.toString());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            Change change = new Change(this.getClass().getSimpleName(), this.getId()
                    , fieldName.toString(), targetField.getType().getSimpleName(), oldValue, newValue);
            this.notifyAllObservers(change);
        } catch (NullPointerException ignore) {
        }
    }

    @Override
    public void attachObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detachObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyAllObservers(Change change) {
        for (Observer observer : this.observers) {
            observer.logChange(change);
        }
    }
}