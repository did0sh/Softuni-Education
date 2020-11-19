package cardealer.domain.dto;

import com.google.gson.annotations.Expose;

public class CarToyotaView {

    @Expose
    private Integer id;

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private Long travelledDistance;

    public CarToyotaView() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return this.travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }
}
