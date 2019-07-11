package springbookproject.springbookproject.Dao;

import org.springframework.stereotype.Repository;
import springbookproject.springbookproject.Beans.Book;
import springbookproject.springbookproject.Beans.Inventory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class InventoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public void create(Inventory inventory) {
        try {
            entityManager.persist(inventory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBook(Book book) {
        try {
      //      return entityManager.createQuery("SELECT b FROM Book b INNER JOIN Inventory i ON " +
      //              "b.bookId = i.bookId WHERE ")
        } catch (Exception e) {
            e.printStackTrace();
        }
     //   return "";
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

    public Inventory getById(Long id) {
        return (Inventory) entityManager.find(Inventory.class, id);
    }

    public void setBookCount(Long book_id, int bookCount) {
        entityManager.find(Book.class, book_id).getInventory().setNumberOfBook(bookCount);
    }

    public void decreaseBookCount(Long book_id) {
        Book book = entityManager.find(Book.class, book_id);
        int currentNumOfBook = book.getInventory().getNumberOfBook();
        currentNumOfBook--;
        book.getInventory().setNumberOfBook(currentNumOfBook);

        if(currentNumOfBook <= 0) {
            entityManager.remove(book);
        }
    }


    public void increaseBookCount(Long book_id) {
        Book book = entityManager.find(Book.class, book_id);
        int currentNumOfBook = book.getInventory().getNumberOfBook();
        currentNumOfBook++;
        book.getInventory().setNumberOfBook(currentNumOfBook);

    }
}
