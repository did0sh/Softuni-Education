package cardealer.domain.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PartsSeedDto {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @Expose
    private Integer quantity;

    public PartsSeedDto() {
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull
    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
