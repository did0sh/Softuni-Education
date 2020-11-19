package cardealer.domain.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerIdNameBirthDateYoungDriverDto {

    @XmlElement(name = "id")
    private Integer id;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "birth-date")
    private String birthDate;

    @XmlElement(name = "is-young-driver")
    private boolean isYoungDriver;

    public CustomerIdNameBirthDateYoungDriverDto() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return this.isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
