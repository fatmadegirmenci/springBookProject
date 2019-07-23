package springbookproject.springbookproject.Dao;

import org.springframework.stereotype.Repository;
import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Cart;
import springbookproject.springbookproject.Domain.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

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

    return entityManager.createNativeQuery("SELECT c.book_id FROM book_cart c WHERE cart_id = :cart_id")
            .setParameter("cart_id", cart_id).getResultList();
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
