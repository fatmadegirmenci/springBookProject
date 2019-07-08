package springbookproject.springbookproject.Beans;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "author_table")
public class Author {

    public Author() {
    }

    public Author(@NotNull String firstName, @NotNull String lastName, @NotNull String country, @NotNull List<Book> book) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.book = book;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "firstName")
    private String firstName;

    @NotNull
    @Column(name = "lastName")
    private String lastName;

    @NotNull
    @Column(name = "country")
    private String country;

    @NotNull
    @ManyToMany(mappedBy = "author")
    private List<Book> book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
}
