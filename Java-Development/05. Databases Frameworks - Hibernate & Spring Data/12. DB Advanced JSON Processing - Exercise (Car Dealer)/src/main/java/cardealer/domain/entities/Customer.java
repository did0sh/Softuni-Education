package cardealer.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity(name = "customers")
public class Customer extends BaseEntity {

    private String name;
    private String birthDate;
    private boolean isYoungDriver;
    private List<Sale> purchases;

    public Customer() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "birth_date", nullable = false)
    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "is_young_driver", nullable = false)
    public boolean isYoungDriver() {
        return this.isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    @OneToMany(mappedBy = "customer")
    public List<Sale> getPurchases() {
        return this.purchases;
    }

    public void setPurchases(List<Sale> purchases) {
        this.purchases = purchases;
    }
}
