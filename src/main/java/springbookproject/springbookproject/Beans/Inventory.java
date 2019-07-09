package springbookproject.springbookproject.Beans;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "inventory_table")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "number_of_book")
    private int numberOfBook;

    @OneToOne
    private Book book;

    public Inventory(@NotNull int numberOfBook, List<Book> book) {
        this.numberOfBook = numberOfBook;
        this.book = (Book) book;
    }

    public Inventory() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfBook() {
        return numberOfBook;
    }

    public void setNumberOfBook(int numberOfBook) {
        this.numberOfBook = numberOfBook;
    }

    public List<Book> getBook() {
        return (List<Book>) book;
    }

    public void setBook(List<Book> book) {
        this.book = (Book) book;
    }
}
