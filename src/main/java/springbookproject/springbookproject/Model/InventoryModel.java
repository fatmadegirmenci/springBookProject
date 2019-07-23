package springbookproject.springbookproject.Model;

import springbookproject.springbookproject.Domain.Book;

public class InventoryModel {

    private Long id;
    private int numberOfBook;
    private Book book;
    private String userName;

    public InventoryModel() {
    }

    public InventoryModel(int numberOfBook, Book book) {
        this.numberOfBook = numberOfBook;
        this.book = book;
    }

    public InventoryModel(int numberOfBook, Book book, String userName) {
        this.numberOfBook = numberOfBook;
        this.book = book;
        this.userName = userName;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
