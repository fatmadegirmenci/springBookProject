package springbookproject.springbookproject.Beans;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "inventory_table")
public class Inventory {

    public Inventory(@NotNull int numberOfBook, @NotNull Book book) {
        this.numberOfBook = numberOfBook;
        this.book = book;
    }

    public Inventory() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "number_of_book")
    private int numberOfBook;

    @NotNull
    @OneToOne
    private Book book;

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
