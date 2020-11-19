package cardealer.domain.dto;

import com.google.gson.annotations.Expose;

import java.util.List;

public class CarWithPartsViewDto {
    @Expose
    private Integer id;

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private Long travelledDistance;

    @Expose
    private List<PartsViewDto> parts;

    public CarWithPartsViewDto() {
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

    public List<PartsViewDto> getParts() {
        return this.parts;
    }

    public void setParts(List<PartsViewDto> parts) {
        this.parts = parts;
    }
}
