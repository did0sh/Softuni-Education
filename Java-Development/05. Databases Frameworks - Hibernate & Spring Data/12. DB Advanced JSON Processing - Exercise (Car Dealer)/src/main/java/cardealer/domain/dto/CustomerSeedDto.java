package cardealer.domain.dto;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerSeedDto {

    @Expose
    private String name;

    @Expose
    private String birthDate;

    @Expose
    private boolean isYoungDriver;

    public CustomerSeedDto() {
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @NotNull
    public boolean isYoungDriver() {
        return this.isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
