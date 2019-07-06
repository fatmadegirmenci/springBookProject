package com.springbookproject.Beans;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Repository
@Table(name = "UserTable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotNull
   // @Column(name = "first_name")
    private String firstName;

    @NotNull
   // @Column(name = "last_name")
    private String lastName;

    @NotNull
   // @Column(name = "register_date")
    private Date registerDate;

    @NotNull
  //  @Column(name = "address")
    private String address;

   // @OneToOne(mappedBy = "user")
   // private Chart chart;


}
