package springbookproject.springbookproject.Model;

import springbookproject.springbookproject.Domain.Book;

public class InventoryModel {

    private Long id;
    private int numberOfBook;
    private Book book;

    public InventoryModel() {
    }

    public InventoryModel(int numberOfBook, Book book) {
        this.numberOfBook = numberOfBook;
        this.book = book;
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
}
