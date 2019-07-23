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
            entityManager.persist(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
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

    @Override
    public boolean checkUserName(String userName) {
        List<User> result = entityManager.createQuery("SELECT u FROM User u WHERE userName = :userName")
                .setParameter("userName", userName).getResultList();

        if(result.size() != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkParola(String userName, int parola) {
        List<User> result = entityManager.createQuery("SELECT u FROM User u WHERE userName = :userName AND " +
                "parola = :parola")
                .setParameter("userName", userName)
                .setParameter("parola", parola).getResultList();

        if(result.size() != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User getByUserName(String userName) {
        return (User) entityManager.createQuery("SELECT u FROM User u WHERE userName = :userName")
                .setParameter("userName", userName).getSingleResult();
    }
}