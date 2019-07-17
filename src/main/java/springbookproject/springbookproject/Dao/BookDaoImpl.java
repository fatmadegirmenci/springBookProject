package springbookproject.springbookproject.Dao;

import org.springframework.stereotype.Repository;
import springbookproject.springbookproject.Domain.Author;
import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(Book book) {
        try {
            entityManager.merge(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Book book) {
        try {
            if (entityManager.contains(book)) {
                entityManager.remove(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book getById(Long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> getByName(String name) {
        return entityManager.createQuery("SELECT b FROM Book b WHERE book_name = :name")
                .setParameter("name", name).getResultList();
    }

    @Override
    public List<Book> getByAuthor(Long id) {
        return entityManager.createNativeQuery("SELECT book_id FROM book_author b WHERE b.author_id= :id")
                .setParameter("id", id).getResultList();
    }

    @Override
    public Book getByCode(String code) {
        return (Book) entityManager.createQuery("SELECT b FROM Book b WHERE code = :code")
                .setParameter("code", code).getSingleResult();
    }

    @Override
    public List<Book> listByPrice() {
        return (List<Book>) entityManager.createNativeQuery("SELECT id FROM book b ORDER BY price ASC")
                .getResultList();
    }

    @Override
    public void addAuthor(Book book, Author author) {
        try {
            book.getAuthor().add(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAuthor(Book book, Author author) {
        try {
            book.getAuthor().remove(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCategory(Book book, Category category) {
        try {
            book.getCategory().add(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategory(Book book, Category category) {
        try {
            book.getCategory().remove(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
