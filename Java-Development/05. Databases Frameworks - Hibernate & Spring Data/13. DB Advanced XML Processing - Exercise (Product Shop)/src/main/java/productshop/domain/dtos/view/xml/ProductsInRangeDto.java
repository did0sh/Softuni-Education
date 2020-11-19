package productshop.domain.dtos.view.xml;

import productshop.domain.dtos.view.ProductNamePriceSellerDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsInRangeDto {

    @XmlElement(name = "product")
    private List<ProductNamePriceSellerDto> productNamePriceSellerDtos;

    public ProductsInRangeDto() {
    }

    public List<ProductNamePriceSellerDto> getProductNamePriceSellerDtos() {
        return this.productNamePriceSellerDtos;
    }

    public void setProductNamePriceSellerDtos(List<ProductNamePriceSellerDto> productNamePriceSellerDtos) {
        this.productNamePriceSellerDtos = productNamePriceSellerDtos;
    }
}
