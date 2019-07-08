package springbookproject.springbookproject.Daos;

import org.springframework.stereotype.Repository;
import springbookproject.springbookproject.Beans.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public void create(User user) {

        try {
            entityManager.persist(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(User user) {

        try {
            if(entityManager.contains(user))
            entityManager.remove(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
