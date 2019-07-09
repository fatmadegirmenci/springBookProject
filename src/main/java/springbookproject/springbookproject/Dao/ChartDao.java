package springbookproject.springbookproject.Dao;

import org.springframework.stereotype.Repository;
import springbookproject.springbookproject.Beans.Book;
import springbookproject.springbookproject.Beans.Chart;
import springbookproject.springbookproject.Beans.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ChartDao {

    @PersistenceContext
    EntityManager entityManager;

    public void create(Chart chart) {
        try {
            entityManager.persist(chart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBook(Book book, User user) {
        try {
            user.getChart().getBook().add(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(List<Book> book, User user) {
        try {
            if(user.getChart().getBook().contains(book)) {
                user.getChart().getBook().remove(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Chart getById(Long id) {
        return (Chart) entityManager.find(Chart.class, id);
    }

    public int getTotalPrice(Long id) {
        return (int) entityManager.createQuery("SELECT total_price FROM Chart WHERE user_id = :id")
                .setParameter("id", id).getSingleResult();
    }

    public List<Book> getBookList(Long user_id) {
        //return entityManager.createQuery("SELECT c FROM chart_book_list_table c").getResultList();

        return  entityManager.createNativeQuery("SELECT c FROM chart_book_list_table c").getResultList();
    }
}
