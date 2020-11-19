package cardealer.domain.dto;

import cardealer.domain.entities.Sale;
import com.google.gson.annotations.Expose;

import java.util.List;

public class CustomerOrderedByBirthDateView {

    @Expose
    private Integer id;

    @Expose
    private String name;

    @Expose
    private String birthDate;

    @Expose
    private boolean isYoungDriver;

    @Expose
    private List<Sale> sales;

    public CustomerOrderedByBirthDateView() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return this.isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public List<Sale> getSales() {
        return this.sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
