package cardealer.domain.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleView {

    @XmlElement(name = "car")
    private List<CarMakeModelDistanceCustomerDiscountPriceDto>
                carMakeModelDistanceCustomerDiscountPriceDtos;

    public SaleView() {
    }

    public List<CarMakeModelDistanceCustomerDiscountPriceDto> getCarMakeModelDistanceCustomerDiscountPriceDtos() {
        return this.carMakeModelDistanceCustomerDiscountPriceDtos;
    }

    public void setCarMakeModelDistanceCustomerDiscountPriceDtos(List<CarMakeModelDistanceCustomerDiscountPriceDto> carMakeModelDistanceCustomerDiscountPriceDtos) {
        this.carMakeModelDistanceCustomerDiscountPriceDtos = carMakeModelDistanceCustomerDiscountPriceDtos;
    }
}
