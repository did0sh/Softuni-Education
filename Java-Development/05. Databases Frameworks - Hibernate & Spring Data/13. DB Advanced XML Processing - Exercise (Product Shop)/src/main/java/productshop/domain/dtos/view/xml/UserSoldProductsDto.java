package productshop.domain.dtos.view.xml;

import productshop.domain.dtos.view.UserFirstNameLastNameDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSoldProductsDto {

    @XmlElement(name = "user")
    private List<UserFirstNameLastNameDto> userFirstNameLastNameDtos;

    public UserSoldProductsDto() {
    }

    public List<UserFirstNameLastNameDto> getUserFirstNameLastNameDtos() {
        return this.userFirstNameLastNameDtos;
    }

    public void setUserFirstNameLastNameDtos(List<UserFirstNameLastNameDto> userFirstNameLastNameDtos) {
        this.userFirstNameLastNameDtos = userFirstNameLastNameDtos;
    }
}
