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
    private String role;
    private String userName;
    private int parola;


    public UserModel() {
    }

    public UserModel(String firstName, String lastName, Date registerDate, String address, Cart cart) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registerDate = registerDate;
        this.address = address;
        this.cart = cart;
    }

    public UserModel(String firstName, String lastName, Date registerDate, String address, Cart cart, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registerDate = registerDate;
        this.address = address;
        this.cart = cart;
        this.role = role;
    }

    public UserModel(String firstName, String lastName, Date registerDate, String address,
                     Cart cart, String role, String userName, int parola) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registerDate = registerDate;
        this.address = address;
        this.cart = cart;
        this.role = role;
        this.userName = userName;
        this.parola = parola;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getParola() {
        return parola;
    }

    public void setParola(int parola) {
        this.parola = parola;
    }
}
