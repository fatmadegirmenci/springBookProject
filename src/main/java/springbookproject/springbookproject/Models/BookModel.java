package springbookproject.springbookproject.Models;

import springbookproject.springbookproject.Beans.Author;
import springbookproject.springbookproject.Beans.Category;
import springbookproject.springbookproject.Beans.Inventory;

import java.util.Date;
import java.util.List;

public class BookModel {

    private Long id;
    private String bookName;
    private String code;
    private Date publishDate;
    private int price;
    private Date updateDate;
    private List<Author> author;
    private List<Category> category;
    private Inventory inventory;

    public BookModel() {
    }

    public BookModel(String bookName, String code, Date publishDate, int price, Date updateDate, List<Author> author, List<Category> category, Inventory inventory) {
        this.bookName = bookName;
        this.code = code;
        this.publishDate = publishDate;
        this.price = price;
        this.updateDate = updateDate;
        this.author = author;
        this.category = category;
        this.inventory = inventory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
