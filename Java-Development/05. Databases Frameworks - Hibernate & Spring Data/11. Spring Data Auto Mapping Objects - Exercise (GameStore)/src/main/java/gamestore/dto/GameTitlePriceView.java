package gamestore.dto;

import java.math.BigDecimal;

public class GameTitlePriceView {
    private String title;
    private BigDecimal price;

    public GameTitlePriceView() {
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getTitle(), this.getPrice());
    }
}
