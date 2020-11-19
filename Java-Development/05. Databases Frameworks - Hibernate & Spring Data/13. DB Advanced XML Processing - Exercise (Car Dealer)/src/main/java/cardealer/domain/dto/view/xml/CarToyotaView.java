package cardealer.domain.dto.view.xml;

import cardealer.domain.dto.view.CarIdMakeModelDistanceDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarToyotaView {

    @XmlElement(name = "car")
    private List<CarIdMakeModelDistanceDto> carIdMakeModelDistanceDtos;

    public CarToyotaView() {
    }

    public List<CarIdMakeModelDistanceDto> getCarIdMakeModelDistanceDtos() {
        return this.carIdMakeModelDistanceDtos;
    }

    public void setCarIdMakeModelDistanceDtos(List<CarIdMakeModelDistanceDto> carIdMakeModelDistanceDtos) {
        this.carIdMakeModelDistanceDtos = carIdMakeModelDistanceDtos;
    }
}
