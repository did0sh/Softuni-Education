package cardealer.domain.dto.view;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarMakeModelDistanceParts {

    @XmlAttribute(name = "make")
    private String make;

    @XmlAttribute(name = "model")
    private String model;

    @XmlAttribute(name = "travelled-distance")
    private Long travelledDistance;

    @XmlElement(name = "parts")
    private List<PartsPartDto> partsPartDtos;

    public CarMakeModelDistanceParts() {
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

    public List<PartsPartDto> getPartsPartDtos() {
        return this.partsPartDtos;
    }

    public void setPartsPartDtos(List<PartsPartDto> partsPartDtos) {
        this.partsPartDtos = partsPartDtos;
    }
}
