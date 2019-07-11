package springbookproject.springbookproject.Beans;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
//@Table(name = "book_table")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "book_name")
    private String bookName;

    @NotNull
    @Column(name = "code")
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

    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.REFRESH,
                            CascadeType.PERSIST
                    },
            targetEntity = Author.class)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id",
                    nullable = false,
                    updatable = false),
            inverseJoinColumns = @JoinColumn(name = "author_id",
                    nullable = false,
                    updatable = false),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
 //   @ManyToMany(cascade = CascadeType.ALL)
 //   @JoinTable(name = "book_author_table", joinColumns = @JoinColumn(name = "book_id"),
  //          inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> author;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.REFRESH,
                            CascadeType.PERSIST
                    },
            targetEntity = Category.class)
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name = "book_id",
                    nullable = false,
                    updatable = false),
            inverseJoinColumns = @JoinColumn(name = "category_id",
                    nullable = false,
                    updatable = false),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
   // @JoinTable(name = "book_category_table", joinColumns = @JoinColumn(name = "book_id"),
   //         inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> category;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.REFRESH,
                            CascadeType.PERSIST
                    },
            targetEntity = Chart.class)
    @JoinTable(name = "book_chart",
            inverseJoinColumns = @JoinColumn(name = "chart_id",
                    nullable = false,
                    updatable = false),
            joinColumns = @JoinColumn(name = "book_id",
                    nullable = false,
                    updatable = false),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private List<Chart> chart;

    @OneToOne(cascade = CascadeType.ALL)
    private Inventory inventory;


    public Book() {
    }


    public Book(@NotNull String bookName, @NotNull String code, @NotNull Date publishDate, @NotNull int price,
                @NotNull Date updateDate, List<Author> author, List<Category> category, List<Chart> chart, Inventory inventory) {
        this.bookName = bookName;
        this.code = code;
        this.publishDate = publishDate;
        this.price = price;
        this.updateDate = updateDate;
        this.author = author;
        this.category = category;
        this.chart = chart;
        this.inventory = inventory;
    }

    public List<Chart> getChart() {
        return chart;
    }

    public void setChart(List<Chart> chart) {
        this.chart = chart;
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
