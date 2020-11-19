package cardealer.domain.dto.seed.xml;

import cardealer.domain.dto.seed.PartSeedDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartsPartDto {

    @XmlElement(name = "part")
    private List<PartSeedDto> partSeedDtos;

    public PartsPartDto() {
    }

    public List<PartSeedDto> getPartSeedDtos() {
        return this.partSeedDtos;
    }

    public void setPartSeedDtos(List<PartSeedDto> partSeedDtos) {
        this.partSeedDtos = partSeedDtos;
    }
}
