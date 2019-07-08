package springbookproject.springbookproject.Models;

import springbookproject.springbookproject.Beans.Book;
import springbookproject.springbookproject.Beans.User;

import java.util.List;

public class ChartModel {

    private Long id;
    private int totalPrice;
    private User user;
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
