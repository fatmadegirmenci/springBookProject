package springbookproject.springbookproject.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "book_name")
    private String bookName;

    @NotNull
    @Column(name = "code", unique = true)
    private String code;

    @NotNull
    @Column(name = "publish_date")
    private Date publishDate;

    @NotNull
    @Column(name = "price")
    private int price;

    @NotNull
    @Column(name = "update_date")
    private Date updateDate;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST}, targetEntity = Author.class)
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "author_id", nullable = false, updatable = false),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private List<Author> author;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST}, targetEntity = Category.class)
    @JoinTable(name = "book_category", joinColumns = @JoinColumn(name = "book_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "category_id", nullable = false, updatable = false),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))

    private List<Category> category;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST}, targetEntity = Cart.class)
    @JoinTable(name = "book_cart", inverseJoinColumns = @JoinColumn(name = "cart_id", nullable = false, updatable = false),
            joinColumns = @JoinColumn(name = "book_id", nullable = false, updatable = false),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private List<Cart> cart;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "book")
    @JsonIgnoreProperties("book")
    private Inventory inventory;


    public Book() {
    }

    public Book(@NotNull String bookName, @NotNull String code, @NotNull Date publishDate, @NotNull int price,
                @NotNull Date updateDate, List<Author> author, List<Category> category, List<Cart> cart, Inventory inventory) {
        this.bookName = bookName;
        this.code = code;
        this.publishDate = publishDate;
        this.price = price;
        this.updateDate = updateDate;
        this.author = author;
        this.category = category;
        this.cart = cart;
        this.inventory = inventory;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
