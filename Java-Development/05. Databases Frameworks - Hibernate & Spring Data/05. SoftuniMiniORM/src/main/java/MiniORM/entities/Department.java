package MiniORM.entities;

import MiniORM.db.annotations.Column;
import MiniORM.db.annotations.Entity;
import MiniORM.db.annotations.PrimaryKey;

@Entity(name = "departments")
public class Department {
    @PrimaryKey(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "company_name")
    private String company;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "| " + getId() + " | " + getName() + " |";
    }
}
