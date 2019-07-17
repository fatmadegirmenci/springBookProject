package springbookproject.springbookproject.Model;

import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.User;

import java.util.List;

public class CartModel {

    private Long id;
    private int totalPrice;
    private User user;
    private List<Book> book;

    public CartModel() {
    }

    public CartModel(int totalPrice, User user, List<Book> book) {
        this.totalPrice = totalPrice;
        this.user = user;
        this.book = book;
    }

    public CartModel(int totalPrice, User user) {
        this.totalPrice = totalPrice;
        this.user = user;
    }

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
