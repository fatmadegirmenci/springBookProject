package springbookproject.springbookproject.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "number_of_book")
    private int numberOfBook;


    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("inventory")
    private Book book;


    public Inventory(@NotNull int numberOfBook, Book book) {
        this.numberOfBook = numberOfBook;
        this.book = book;
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

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}
