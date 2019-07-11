package springbookproject.springbookproject.Dao;

import org.springframework.stereotype.Repository;
import springbookproject.springbookproject.Beans.Author;
import springbookproject.springbookproject.Beans.Book;
import springbookproject.springbookproject.Beans.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;

    public void create(Book book) {
        try {
            entityManager.persist(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Book book) {
        try {
            if(entityManager.contains(book)) {
                entityManager.remove(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Book getById(Long id) {
        return (Book) entityManager.find(Book.class, id);
    }

    public List<Book> getByName(String name) {
        return entityManager.createQuery("SELECT b FROM Book b WHERE book_name = :name")
                .setParameter("name", name).getResultList();
    }

    public List<Book> getByAuthor(Long id) {
        return entityManager.createNativeQuery("SELECT book_id FROM book_author b WHERE b.author_id= :id")
                .setParameter("id", id).getResultList();
    }

    public Book getByCode(String code) {
        return (Book) entityManager.createQuery("SELECT b FROM Book b WHERE code = :code")
                .setParameter("code", code).getSingleResult();
    }

    public List<Book> listByPrice() {
        return (List<Book>) entityManager.createNativeQuery("SELECT id FROM book b ORDER BY price ASC")
                .getResultList();
    }

    public void addAuthor(Book book, Author author) {
        try {
            book.getAuthor().add(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAuthor(Book book, Author author) {
        try {
            book.getAuthor().remove(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCategory(Book book, Category category) {
        try {
            book.getCategory().add(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCategory(Book book, Category category) {
        try {
            book.getCategory().remove(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
