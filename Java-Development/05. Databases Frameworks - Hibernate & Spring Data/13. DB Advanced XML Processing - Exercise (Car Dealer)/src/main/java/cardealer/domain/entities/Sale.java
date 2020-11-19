package cardealer.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "sales")
public class Sale extends BaseEntity {

    private Double discount;
    private Car car;
    private Customer customer;

    public Sale() {
    }

    @Column(name = "discount", nullable = false)
    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @OneToOne
    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne
    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
