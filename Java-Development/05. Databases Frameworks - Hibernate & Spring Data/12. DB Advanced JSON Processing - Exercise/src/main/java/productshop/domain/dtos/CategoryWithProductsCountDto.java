package productshop.domain.dtos;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class CategoryWithProductsCountDto {

    @Expose
    private String name;

    @Expose
    private int productsCount;

    @Expose
    private double averagePrice;

    @Expose
    private BigDecimal totalRevenue;

    public CategoryWithProductsCountDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductsCount() {
        return this.productsCount;
    }

    public void setProductsCount(int productsCount) {
        this.productsCount = productsCount;
    }

    public double getAveragePrice() {
        return this.averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return this.totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
