package springbookproject.springbookproject.Dao;

import jdk.nashorn.internal.runtime.Debug;
import org.springframework.stereotype.Repository;
import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Cart;
import springbookproject.springbookproject.Domain.User;
import sun.rmi.runtime.Log;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(Cart cart) {
        try {
            entityManager.persist(cart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBook(Book book, User user) {
        try {
           // user.getCart().getBook().add(book);
            book.getCart().add(user.getCart());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(Book book, Cart cart) {
        try {
            if(book.getCart().contains(cart)) {
                book.getCart().remove(cart);
            //    book.setCart(null);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cart getById(Long id) {
        return entityManager.find(Cart.class, id);
    }

    @Override
    public List<Book> getBookList(User user) {
        Long cart_id = user.getCart().getId();
    /*    List<BigInteger> bookIds = (List<BigInteger>) entityManager.createNativeQuery("SELECT c.book_id FROM book_cart c WHERE cart_id = :cart_id")
                .setParameter("cart_id", cart_id).getResultList();
        List<Book> books =new ArrayList<>();
        System.out.println(bookIds.get(0));
        for(int i=0;i<bookIds.size();i++){
            Long x = (bookIds.get(0)).toString();
            Book a = entityManager.find(Book.class, (long)x);
            books.add(a);
        }

        return books;*/
    return entityManager.createNativeQuery("SELECT c.book_id FROM book_cart c WHERE cart_id = :cart_id")
            .setParameter("cart_id", cart_id).getResultList();

      /*  List<BigInteger> bookIds = (List<BigInteger>) entityManager.createNativeQuery("SELECT c.book_id FROM book_cart c WHERE cart_id = :cart_id")
                .setParameter("cart_id", cart_id).getResultList();
        List<Book> books =new ArrayList<>();
        System.out.println(bookIds.get(0));
        for(int i=0;i<bookIds.size();i++){
            Long x = bookIds.get(i);
            Book a = (Book) entityManager.createQuery("SELECT b FROM Book b WHERE " +
                    "b.id = :x").setParameter("x", x).getSingleResult();
            books.add(a);
        }

        return books;*/
    }

    @Override
    public List<Cart> getByUser(Long userId) {
        return entityManager.createNativeQuery("SELECT c.id FROM cart c WHERE c.user_id = :userId")
                .setParameter("userId", userId).getResultList();
    }

    @Override
    public int getTotalPriceByUser(Long userId) {
        return (int) entityManager.createNativeQuery("SELECT total_price FROM cart WHERE user_id = :userId")
                .setParameter("userId", userId).getSingleResult();
    }
}
