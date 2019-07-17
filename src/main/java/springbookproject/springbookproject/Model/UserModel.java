package springbookproject.springbookproject.Model;

//import springbookproject.springbookproject.Domain.Cart;

import springbookproject.springbookproject.Domain.Cart;

import java.util.Date;

public class UserModel {

    private Long id;
    private String firstName;
    private String lastName;
    private Date registerDate;
    private String address;
    private Cart cart;

    public UserModel() {
    }

    public UserModel(String firstName, String lastName, Date registerDate, String address, Cart cart) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registerDate = registerDate;
        this.address = address;
        this.cart = cart;
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

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
