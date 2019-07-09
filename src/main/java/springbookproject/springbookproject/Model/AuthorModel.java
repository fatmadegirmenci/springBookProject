package springbookproject.springbookproject.Model;

import springbookproject.springbookproject.Beans.Book;

import java.util.List;

public class AuthorModel {

    private Long id;
    private String firstName;
    private String lastName;
    private String country;
    private List<Book> book;

    public AuthorModel() {
    }

    public AuthorModel(String firstName, String lastName, String country, List<Book> book) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.book = book;
    }

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
