package cardealer.domain.dto.seed.xml;

import cardealer.domain.dto.seed.CustomerSeedDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersCustomerDto {

    @XmlElement(name = "customer")
    private List<CustomerSeedDto> customerSeedDtos;

    public CustomersCustomerDto() {
    }

    public List<CustomerSeedDto> getCustomerSeedDtos() {
        return this.customerSeedDtos;
    }

    public void setCustomerSeedDtos(List<CustomerSeedDto> customerSeedDtos) {
        this.customerSeedDtos = customerSeedDtos;
    }
}
