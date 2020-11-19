package fdmcv2.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "cats")
public class Cat extends BaseEntity {

    private String name;
    private String breed;
    private String color;
    private Integer age;
    private String gender;
    private BigDecimal price;
    private Date addedOn;
    private boolean passport;

    public Cat() {
    }

    @Column(name = "name", nullable = false)
    @Size(min = 2, max = 10)
    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "breed", nullable = false)
    @Size(min = 5, max = 20)
    @NotNull
    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Column(name = "color", nullable = false)
    @NotNull
    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "age", nullable = false)
    @Min(value = 1)
    @Max(value = 31)
    @NotNull
    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "gender", nullable = false)
    @NotNull
    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "price", nullable = false)
    @DecimalMin(value = "0.01")
    @NotNull
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "added_on", nullable = false)
    @NotNull
    public Date getAddedOn() {
        return this.addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    @Column(name = "has_passport", nullable = false)
    @NotNull
    public boolean getPassport() {
        return this.passport;
    }

    public void setPassport(boolean hasPassport) {
        this.passport = hasPassport;
    }
}
