package gamestore.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    private Long id;
    private User buyer;
    private Set<Game> products;

    public Order() {
        this.products = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    public User getBuyer() {
        return this.buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    @ManyToMany
    @JoinTable(name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id")
    )
    public Set<Game> getProducts() {
        return this.products;
    }

    public void setProducts(Set<Game> products) {
        this.products = products;
    }
}
