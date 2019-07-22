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
         //   if(user.getId() == null)

          //  entityManager.getTransaction().begin();
            entityManager.persist(user);
       //     entityManager.getTransaction().commit();

        //        entityManager.persist(user);
         //   else
        //        entityManager.merge(user)
            //       user.setCart(cart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user, List<Book> books) {
        try {
            if (entityManager.contains(user)) {
         //       User u=entityManager.find(User.class,user.getId());
              //  entityManager.remove(user);

           //     entityManager.getTransaction().begin();
                entityManager.remove(user);
           //     entityManager.merge(user);
         //       entityManager.flush();
         //       entityManager.refresh(user);
       //         entityManager.getTransaction().commit();
            //    entityManager.remove(user.getCart().getUser());
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