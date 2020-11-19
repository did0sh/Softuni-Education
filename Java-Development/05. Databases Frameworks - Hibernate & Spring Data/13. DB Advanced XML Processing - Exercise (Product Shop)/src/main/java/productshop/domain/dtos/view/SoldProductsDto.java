package productshop.domain.dtos.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoldProductsDto {

    @XmlElement(name = "product")
    private List<ProductNamePriceFirstNameLastNameDto> productNamePriceFirstNameLastNameDtos;

    public SoldProductsDto() {
    }

    public List<ProductNamePriceFirstNameLastNameDto> getProductNamePriceFirstNameLastNameDtos() {
        return this.productNamePriceFirstNameLastNameDtos;
    }

    public void setProductNamePriceFirstNameLastNameDtos(List<ProductNamePriceFirstNameLastNameDto> productNamePriceFirstNameLastNameDtos) {
        this.productNamePriceFirstNameLastNameDtos = productNamePriceFirstNameLastNameDtos;
    }
}
