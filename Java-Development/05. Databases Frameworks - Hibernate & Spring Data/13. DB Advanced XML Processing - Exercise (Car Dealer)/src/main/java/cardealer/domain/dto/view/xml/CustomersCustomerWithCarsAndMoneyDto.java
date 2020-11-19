package cardealer.domain.dto.view.xml;

import cardealer.domain.dto.view.CustomerNameCarsSpentMoney;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersCustomerWithCarsAndMoneyDto {

    @XmlElement(name = "customer")
    private List<CustomerNameCarsSpentMoney> customerNameCarsSpentMonies;

    public CustomersCustomerWithCarsAndMoneyDto() {
    }

    public List<CustomerNameCarsSpentMoney> getCustomerNameCarsSpentMonies() {
        return this.customerNameCarsSpentMonies;
    }

    public void setCustomerNameCarsSpentMonies(List<CustomerNameCarsSpentMoney> customerNameCarsSpentMonies) {
        this.customerNameCarsSpentMonies = customerNameCarsSpentMonies;
    }
}
