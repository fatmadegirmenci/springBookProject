package springbookproject.springbookproject.Beans;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "category_table")
public class Category {

    public Category() {
    }

    public Category(@NotNull String category, @NotNull List<Book> book) {
        this.category = category;
        this.book = book;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "category")
    private String category;

    @NotNull
    @ManyToMany(mappedBy = "category")
    private List<Book> book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
}
