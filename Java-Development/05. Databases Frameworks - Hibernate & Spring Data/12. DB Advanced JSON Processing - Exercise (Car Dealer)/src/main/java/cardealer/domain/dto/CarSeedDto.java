package cardealer.domain.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;

public class CarSeedDto {

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private Long travelledDistance;

    public CarSeedDto() {
    }

    @NotNull
    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @NotNull
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @NotNull
    public Long getTravelledDistance() {
        return this.travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }
}
