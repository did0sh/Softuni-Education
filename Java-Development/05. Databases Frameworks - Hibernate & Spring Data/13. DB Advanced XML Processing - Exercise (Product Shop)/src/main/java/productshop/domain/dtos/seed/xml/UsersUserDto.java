package productshop.domain.dtos.seed.xml;

import productshop.domain.dtos.seed.UserSeedDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersUserDto {

    @XmlElement(name = "user")
    private List<UserSeedDto> userSeedDtos;

    public UsersUserDto() {
    }

    public List<UserSeedDto> getUserSeedDtos() {
        return this.userSeedDtos;
    }

    public void setUserSeedDtos(List<UserSeedDto> userSeedDtos) {
        this.userSeedDtos = userSeedDtos;
    }
}
