package cardealer.domain.dto.view.xml;

import cardealer.domain.dto.view.SaleView;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleViewDto {

    @XmlElement(name = "sale")
    private List<SaleView> saleViews;

    public SaleViewDto() {
    }

    public List<SaleView> getSaleViews() {
        return this.saleViews;
    }

    public void setSaleViews(List<SaleView> saleViews) {
        this.saleViews = saleViews;
    }
}
