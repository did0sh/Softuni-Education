package gamestore.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "games")
public class Game {
    private Long id;
    private String title;
    private String trailer;
    private String imageURL;
    private BigDecimal size;
    private BigDecimal price;
    private String description;
    private Date releaseDate;

    public Game() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title", unique = true)
    @Length(min = 3, max = 100)
    @Pattern(regexp = "^[A-Z].+$")
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "trailer")
    @Length(min = 11, max = 11)
    public String getTrailer() {
        return this.trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Column(name = "image_url")
    @Pattern(regexp = "^(http|https)://.*$")
    public String getImageURL() {
        return this.imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Column(name = "size")
    @Digits(integer = 5, fraction = 1)
    public BigDecimal getSize() {
        return this.size;
    }

    public void setSize(BigDecimal size) {
        if (size.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Size must be positive!");
        }
        this.size = size;
    }

    @Column(name = "price")
    @Digits(integer = 5, fraction = 2)
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be positive!");
        }
        this.price = price;
    }

    @Column(name = "description")
    @Length(min = 20)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "release_date")
    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
