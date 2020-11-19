package cardealer.domain.dto.seed;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartSeedDto {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "price")
    private BigDecimal price;

    @XmlAttribute(name = "quantity")
    private Integer quantity;

    public PartSeedDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
