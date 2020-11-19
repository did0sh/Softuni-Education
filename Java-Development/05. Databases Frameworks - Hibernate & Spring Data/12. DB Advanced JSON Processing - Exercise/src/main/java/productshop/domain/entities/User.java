package productshop.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private Integer age;
    private List<User> friends;
    private List<Product> sell;

    public User() {
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "age")
    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @ManyToMany(targetEntity = User.class)
    @JoinTable(name = "users_friends",
                joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id")
    )
    public List<User> getFriends() {
        return this.friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    @OneToMany(targetEntity = Product.class, mappedBy = "seller", fetch = FetchType.EAGER)
    public List<Product> getSell() {
        return this.sell;
    }

    public void setSell(List<Product> sell) {
        this.sell = sell;
    }
}
