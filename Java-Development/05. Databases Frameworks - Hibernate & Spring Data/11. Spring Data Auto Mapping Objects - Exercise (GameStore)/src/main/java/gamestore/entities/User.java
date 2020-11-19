package gamestore.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    private Long id;
    private boolean isAdmin;
    private String email;
    private String password;
    private String fullName;
    private Set<Order> orders;
    private Set<Game> games;

    public User() {
        this.orders = new HashSet<>();
        this.games = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "is_admin")
    public boolean isAdmin() {
        return this.isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Column(name = "email", unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9]+[-_.]*[a-zA-Z0-9]+@[a-zA-Z0-9]+" +
            "[-_.]*[a-zA-Z0-9](\\.[a-zA-Z0-9]+[-_.]*[a-zA-Z0-9]+)+$"
            , message = "Please provide a valid email address")
    @Length(max = 100)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", length = 50, nullable = false)
    @Pattern(regexp = "^(?=^.{6,}$)(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).*$")
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "full_name", length = 100)
    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @OneToMany(mappedBy = "buyer", fetch = FetchType.EAGER)
    public Set<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_games",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id")
    )
    public Set<Game> getGames() {
        return this.games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
