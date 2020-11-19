package cardealer.domain.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartsPartDto {

    @XmlElement(name = "part")
    private List<PartNamePriceDto> partNamePriceDtos;

    public PartsPartDto() {
    }

    public List<PartNamePriceDto> getPartNamePriceDtos() {
        return this.partNamePriceDtos;
    }

    public void setPartNamePriceDtos(List<PartNamePriceDto> partNamePriceDtos) {
        this.partNamePriceDtos = partNamePriceDtos;
    }
}
