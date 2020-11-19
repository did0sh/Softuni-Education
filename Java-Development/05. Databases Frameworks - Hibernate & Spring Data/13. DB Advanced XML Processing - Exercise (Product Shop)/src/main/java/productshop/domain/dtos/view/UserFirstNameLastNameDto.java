package productshop.domain.dtos.view;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserFirstNameLastNameDto {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlElement(name = "sold-products")
    private List<SoldProductsDto> soldProductsDtos;

    public UserFirstNameLastNameDto() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<SoldProductsDto> getSoldProductsDtos() {
        return this.soldProductsDtos;
    }

    public void setSoldProductsDtos(List<SoldProductsDto> soldProductsDtos) {
        this.soldProductsDtos = soldProductsDtos;
    }
}
