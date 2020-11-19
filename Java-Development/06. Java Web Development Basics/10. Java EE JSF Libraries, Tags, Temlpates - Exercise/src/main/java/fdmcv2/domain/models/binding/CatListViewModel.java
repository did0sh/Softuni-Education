package fdmcv2.domain.models.binding;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

public class CatListViewModel {

    private String name;
    private String breed;
    private String color;
    private Integer age;
    private String gender;
    private BigDecimal price;
    private Date addedOn;
    private boolean passport;

    public CatListViewModel() {
    }

    @Size(min = 2, max = 10)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 5, max = 20)
    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Min(value = 1)
    @Max(value = 31)
    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @DecimalMin(value = "0.01")
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getAddedOn() {
        return this.addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public boolean getPassport() {
        return this.passport;
    }

    public void setPassport(boolean passport) {
        this.passport = passport;
    }
}
