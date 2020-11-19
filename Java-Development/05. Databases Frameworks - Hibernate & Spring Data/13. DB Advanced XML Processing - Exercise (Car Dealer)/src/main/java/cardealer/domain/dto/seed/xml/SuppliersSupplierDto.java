package cardealer.domain.dto.seed.xml;

import cardealer.domain.dto.seed.SupplierSeedDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SuppliersSupplierDto {

    @XmlElement(name = "supplier")
    private List<SupplierSeedDto> supplierSeedDtos;

    public SuppliersSupplierDto() {
    }

    public List<SupplierSeedDto> getSupplierSeedDtos() {
        return this.supplierSeedDtos;
    }

    public void setSupplierSeedDtos(List<SupplierSeedDto> supplierSeedDtos) {
        this.supplierSeedDtos = supplierSeedDtos;
    }
}
