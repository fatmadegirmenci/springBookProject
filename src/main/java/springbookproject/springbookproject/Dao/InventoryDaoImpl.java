package springbookproject.springbookproject.Dao;

import org.springframework.stereotype.Repository;
import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Inventory;
import springbookproject.springbookproject.Service.InventoryService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class InventoryDaoImpl implements InventoryDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(Inventory inventory) {
        try {
            entityManager.persist(inventory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBook(Book book) {
        try {
            //      return entityManager.createQuery("SELECT b FROM Book b INNER JOIN Inventory i ON " +
            //              "b.bookId = i.bookId WHERE ")
        } catch (Exception e) {
            e.printStackTrace();
        }
        //   return "";
    }

    @Override
    public void deleteBook(Book book) {
        try {
            if (entityManager.contains(book)) {

                entityManager.remove(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Inventory getById(Long id) {
        return (Inventory) entityManager.find(Inventory.class, id);
    }

    @Override
    public void setBookCount(Long book_id, int bookCount) {
        entityManager.find(Book.class, book_id).getInventory().setNumberOfBook(bookCount);

    }

    @Override
    public void decreaseBookCount(Long book_id) {
        Book book = entityManager.find(Book.class, book_id);
        int currentNumOfBook = book.getInventory().getNumberOfBook();
        currentNumOfBook--;
        book.getInventory().setNumberOfBook(currentNumOfBook);

        if (currentNumOfBook <= 0) {
            entityManager.remove(book);
        }
    }

    @Override
    public void increaseBookCount(Long book_id) {
        Book book = entityManager.find(Book.class, book_id);
        int currentNumOfBook = book.getInventory().getNumberOfBook();
        currentNumOfBook++;
        book.getInventory().setNumberOfBook(currentNumOfBook);

    }

}