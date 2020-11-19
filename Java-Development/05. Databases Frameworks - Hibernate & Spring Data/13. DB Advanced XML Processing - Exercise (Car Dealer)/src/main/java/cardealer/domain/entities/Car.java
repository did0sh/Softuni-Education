package cardealer.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "cars")
public class Car extends BaseEntity {

    private String make;
    private String model;
    private Long travelledDistance;
    private List<Part> parts;

    public Car() {
    }

    @Column(name = "make", nullable = false)
    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(name = "model", nullable = false)
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "travelled_distance", nullable = false)
    public Long getTravelledDistance() {
        return this.travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    @ManyToMany(targetEntity = Part.class, fetch = FetchType.EAGER)
    @JoinTable(name = "parts_cars",
                joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id")
    )
    public List<Part> getParts() {
        return this.parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }
}
