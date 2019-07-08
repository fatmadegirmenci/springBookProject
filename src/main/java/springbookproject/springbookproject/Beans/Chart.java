package springbookproject.springbookproject.Beans;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "chart_table")
public class Chart {

    public Chart() {
    }

    public Chart(@NotNull int totalPrice, @NotNull User user, @NotNull List<Book> book) {
        this.totalPrice = totalPrice;
        this.user = user;
        this.book = book;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "total_price")
    private int totalPrice;

    @NotNull
    @OneToOne
    private User user;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "chart_book_list_table", joinColumns = @JoinColumn(name = "chart_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> book;

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
