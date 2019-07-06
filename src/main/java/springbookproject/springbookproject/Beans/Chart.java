package com.springbookproject.Beans;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Repository
@Table(name = "ChartTable")
public class Chart {

    private Long book_id;

    @NotNull
  //  @Column(name = "number_of_books")
    private int numberOfBooks;

    @NotNull
  // @Column(name = "total_price")
    private int totalPrice;

  //  @OneToOne(cascade = CascadeType.ALL)
  //  @JoinColumn(name = "user_id", referencedColumnName = "user_id")
 //   private User user;
}
