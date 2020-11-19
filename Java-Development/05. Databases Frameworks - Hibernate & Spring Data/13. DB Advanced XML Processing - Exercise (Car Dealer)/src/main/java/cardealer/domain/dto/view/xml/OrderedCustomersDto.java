package cardealer.domain.dto.view.xml;

import cardealer.domain.dto.view.CustomerIdNameBirthDateYoungDriverDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderedCustomersDto {

    @XmlElement(name = "customer")
    private List<CustomerIdNameBirthDateYoungDriverDto>
                    customerIdNameBirthDateYoungDriverDtos;


    public OrderedCustomersDto() {
    }

    public List<CustomerIdNameBirthDateYoungDriverDto> getCustomerIdNameBirthDateYoungDriverDtos() {
        return this.customerIdNameBirthDateYoungDriverDtos;
    }

    public void setCustomerIdNameBirthDateYoungDriverDtos(List<CustomerIdNameBirthDateYoungDriverDto> customerIdNameBirthDateYoungDriverDtos) {
        this.customerIdNameBirthDateYoungDriverDtos = customerIdNameBirthDateYoungDriverDtos;
    }
}
