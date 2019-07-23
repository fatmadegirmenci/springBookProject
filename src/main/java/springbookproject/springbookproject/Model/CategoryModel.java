package springbookproject.springbookproject.Model;

import springbookproject.springbookproject.Domain.Book;
import java.util.List;

public class CategoryModel {

    private Long id;
    private String category;
    private List<Book> book;
    private String userName;

    public CategoryModel() {
    }

    public CategoryModel(String category, List<Book> book) {
        this.category = category;
        this.book = book;
    }

    public CategoryModel(String category, List<Book> book, String userName) {
        this.category = category;
        this.book = book;
        this.userName = userName;
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
