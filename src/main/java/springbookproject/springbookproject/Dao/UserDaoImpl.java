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
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void create(User user, Cart cart) {
        try {
            entityManager.merge(user);
            //       user.setCart(cart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user, List<Book> books) {
        try {
            if (entityManager.contains(user)) {
                entityManager.remove(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }
}