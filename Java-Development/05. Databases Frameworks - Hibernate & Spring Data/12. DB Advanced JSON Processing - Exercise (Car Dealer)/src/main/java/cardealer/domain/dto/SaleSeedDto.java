package cardealer.domain.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;

public class SaleSeedDto {

    @Expose
    private Integer carId;

    @Expose
    private Integer customerId;

    @Expose
    private Double discount;

    public SaleSeedDto() {
    }

    @NotNull
    public Integer getCarId() {
        return this.carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    @NotNull
    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @NotNull
    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
