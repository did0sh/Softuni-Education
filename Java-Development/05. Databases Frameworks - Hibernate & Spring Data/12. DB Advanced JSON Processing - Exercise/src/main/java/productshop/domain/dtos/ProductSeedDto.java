package productshop.domain.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ProductSeedDto {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    public ProductSeedDto() {
    }

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, message = "Name must be at least 3 symbols long")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.01", message = "Price must be a positive number")
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
