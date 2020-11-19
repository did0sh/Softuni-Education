package gamestore.dto;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GameDetailsView {
    private String title;
    private BigDecimal price;
    private String description;
    private Date releaseDate;

    public GameDetailsView() {
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sb.append(String.format("Title: %s", this.getTitle())).append(System.lineSeparator());
        sb.append(String.format("Price: %s", this.getPrice())).append(System.lineSeparator());
        sb.append(String.format("Description: %s", this.getDescription())).append(System.lineSeparator());
        sb.append(String.format("Release date: %s", sdf.format(this.getReleaseDate())));
        return sb.toString();
    }
}
