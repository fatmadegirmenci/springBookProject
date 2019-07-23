package springbookproject.springbookproject.Model;

import springbookproject.springbookproject.Domain.Author;
import springbookproject.springbookproject.Domain.Cart;
import springbookproject.springbookproject.Domain.Category;
import springbookproject.springbookproject.Domain.Inventory;
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
    private List<Cart> cart;
    private String userName;

    public BookModel() {
    }

    public BookModel(String bookName, String code, Date publishDate, int price, Date updateDate, List<Author> author, List<Category> category, Inventory inventory, List<Cart> cart) {
        this.bookName = bookName;
        this.code = code;
        this.publishDate = publishDate;
        this.price = price;
        this.updateDate = updateDate;
        this.author = author;
        this.category = category;
        this.inventory = inventory;
        this.cart = cart;
    }

    public BookModel(String bookName, String code, Date publishDate, int price, Date updateDate, List<Author> author, List<Category> category, Inventory inventory, List<Cart> cart, String userName) {
        this.bookName = bookName;
        this.code = code;
        this.publishDate = publishDate;
        this.price = price;
        this.updateDate = updateDate;
        this.author = author;
        this.category = category;
        this.inventory = inventory;
        this.cart = cart;
        this.userName = userName;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
