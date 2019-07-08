package springbookproject.springbookproject.Daos;

import org.springframework.stereotype.Repository;
import springbookproject.springbookproject.Beans.Book;
import springbookproject.springbookproject.Beans.Inventory;
import springbookproject.springbookproject.Models.InventoryModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class InventoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public void addBook(Book book) {
        try {
            entityManager.persist(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(Book book) {
        try {
            if(entityManager.contains(book)) {
                entityManager.remove(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBookCount(Long book_id, int bookCount) {
        entityManager.find(Book.class, book_id).getInventory().setNumberOfBook(bookCount);
    }

    public void decreaseBookCount(Long book_id) {
        int currentNumOfBook = entityManager.find(Book.class, book_id).getInventory().getNumberOfBook();

        entityManager.find(Book.class, book_id).getInventory().setNumberOfBook(currentNumOfBook--);
    }


    public void increaseBookCount(Long book_id) {
        int currentNumOfBook = entityManager.find(Book.class, book_id).getInventory().getNumberOfBook();

        entityManager.find(Book.class, book_id).getInventory().setNumberOfBook(currentNumOfBook++);
    }
}
