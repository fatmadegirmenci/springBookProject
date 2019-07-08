package springbookproject.springbookproject.Daos;

import org.springframework.stereotype.Repository;
import springbookproject.springbookproject.Beans.Book;
import springbookproject.springbookproject.Beans.Chart;
import springbookproject.springbookproject.Beans.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ChartDao {

    @PersistenceContext
    EntityManager entityManager;

    public void addBook(Book book, User user) {
        try {
            user.getChart().getBook().add(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(Book book, User user) {
        try {
            if(user.getChart().getBook().contains(book)) {
                user.getChart().getBook().remove(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Chart getChart(Long id) {
        return (Chart) entityManager.createQuery("SELECT c FROM Chart c WHERE user_id = :id")
                .setParameter("id", id).getSingleResult();
    }

    public int getTotalPrice(Long id) {
        return (int) entityManager.createQuery("SELECT total_price FROM Chart c WHERE user_id = :id")
                .setParameter("id", id).getSingleResult();
    }



}
