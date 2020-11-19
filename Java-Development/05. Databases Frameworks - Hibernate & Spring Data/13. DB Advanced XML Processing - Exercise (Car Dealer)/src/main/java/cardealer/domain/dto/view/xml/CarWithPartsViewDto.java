package cardealer.domain.dto.view.xml;

import cardealer.domain.dto.view.CarMakeModelDistanceParts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWithPartsViewDto {

    @XmlElement(name = "car")
    private List<CarMakeModelDistanceParts> carMakeModelDistanceParts;

    public CarWithPartsViewDto() {
    }

    public List<CarMakeModelDistanceParts> getCarMakeModelDistanceParts() {
        return this.carMakeModelDistanceParts;
    }

    public void setCarMakeModelDistanceParts(List<CarMakeModelDistanceParts> carMakeModelDistanceParts) {
        this.carMakeModelDistanceParts = carMakeModelDistanceParts;
    }
}
