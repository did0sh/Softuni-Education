package cardealer.domain.dto.seed.xml;

import cardealer.domain.dto.seed.CarSeedDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsCarDto {

    @XmlElement(name = "car")
    private List<CarSeedDto> carSeedDtos;

    public CarsCarDto() {
    }

    public List<CarSeedDto> getCarSeedDtos() {
        return this.carSeedDtos;
    }

    public void setCarSeedDtos(List<CarSeedDto> carSeedDtos) {
        this.carSeedDtos = carSeedDtos;
    }
}
