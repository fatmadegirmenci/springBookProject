package springbookproject.springbookproject.Dao;

import org.springframework.stereotype.Repository;
import springbookproject.springbookproject.Beans.Chart;
import springbookproject.springbookproject.Beans.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public void create(User user, Chart chart) {
        try {
            entityManager.persist(user);
            user.setChart(chart);
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

  /*  public void update(User user) {
        try {
            if(entityManager.contains(user))
                String sql = "update User set firstName='" + user.getFirstName() + "', lastName='" +
                        user.getLastName() + "', address='" + user.getAddress() + "', registerDate='" +
                        user.getRegisterDate().toString() + "', chart_id='" + user.getChart().getId().toString() + "' where id=" +user.getId()+"".toString();
                entityManager.createQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/


    public User getById(Long id) {
        return (User) entityManager.find(User.class, id);
    }
}
