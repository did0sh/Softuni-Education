package productshop.domain.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UserSoldProductsDto {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private List<SoldProductsDto> soldProducts;

    public UserSoldProductsDto() {
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

    public List<SoldProductsDto> getSoldProducts() {
        return this.soldProducts;
    }

    public void setSoldProducts(List<SoldProductsDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
