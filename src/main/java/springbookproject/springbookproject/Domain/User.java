package springbookproject.springbookproject.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "usert")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "register_date")
    private Date registerDate;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    private String role;

    @NotNull
    @Column(unique = true)
    private String userName;

    @NotNull
    private int parola;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Cart cart;


    public User() {
    }

    public User(@NotNull String firstName, @NotNull String lastName,
                @NotNull Date registerDate, @NotNull String address, Cart cart) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registerDate = registerDate;
        this.address = address;
        this.cart = cart;
    }

    public User(@NotNull String firstName, @NotNull String lastName, @NotNull Date registerDate,
                @NotNull String address, @NotNull String role, Cart cart) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registerDate = registerDate;
        this.address = address;
        this.role = role;
        this.cart = cart;
    }

    public User(@NotNull String firstName, @NotNull String lastName, @NotNull Date registerDate,
                @NotNull String address, @NotNull String role, @NotNull String userName, @NotNull int parola, Cart cart) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registerDate = registerDate;
        this.address = address;
        this.role = role;
        this.userName = userName;
        this.parola = parola;
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
