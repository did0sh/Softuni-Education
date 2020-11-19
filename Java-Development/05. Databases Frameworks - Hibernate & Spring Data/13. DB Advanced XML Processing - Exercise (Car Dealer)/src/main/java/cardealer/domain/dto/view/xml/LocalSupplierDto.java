package cardealer.domain.dto.view.xml;

import cardealer.domain.dto.view.SupplierIdNamePartsCountDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalSupplierDto {

    @XmlElement(name = "supplier")
    private List<SupplierIdNamePartsCountDto> supplierIdNamePartsCountDtos;

    public LocalSupplierDto() {
    }

    public List<SupplierIdNamePartsCountDto> getSupplierIdNamePartsCountDtos() {
        return this.supplierIdNamePartsCountDtos;
    }

    public void setSupplierIdNamePartsCountDtos(List<SupplierIdNamePartsCountDto> supplierIdNamePartsCountDtos) {
        this.supplierIdNamePartsCountDtos = supplierIdNamePartsCountDtos;
    }
}
