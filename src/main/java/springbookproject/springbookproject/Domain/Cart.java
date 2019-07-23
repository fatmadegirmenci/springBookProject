package springbookproject.springbookproject.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "total_price")
    private int totalPrice;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST}, targetEntity = Book.class)
    @JoinTable(name = "book_cart", joinColumns = @JoinColumn(name = "cart_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "book_id", nullable = false, updatable = false),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT), inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private List<Book> book;


    public Cart() {
    }

    public Cart(@NotNull int totalPrice, User user, List<Book> book) {
        this.totalPrice = totalPrice;
        this.user = user;
        this.book = book;
    }

    public Cart(@NotNull int totalPrice, User user) {
        this.totalPrice = totalPrice;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
}
