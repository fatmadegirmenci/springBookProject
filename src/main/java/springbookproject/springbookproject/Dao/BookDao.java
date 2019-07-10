package springbookproject.springbookproject.Dao;

import org.springframework.stereotype.Repository;
import springbookproject.springbookproject.Beans.Author;
import springbookproject.springbookproject.Beans.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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

    public Book getByName(String name) {
        return (Book) entityManager.createQuery("SELECT b FROM Book b WHERE book_name = :name")
                .setParameter("name", name).getResultList();
    }

    public Book getByAuthor(Author author) {
        return (Book) entityManager.createNativeQuery("SELECT b FROM book_author b WHERE b.author_id= :author")
                .setParameter("author", author.getId()).getResultList();
    }

    public Book getByCode(String code) {
        return (Book) entityManager.createQuery("SELECT b FROM Book b WHERE code = :code")
                .setParameter("code", code).getSingleResult();
    }

    public Book listByPrice() {
        return (Book) entityManager.createQuery("SELECT b FROM Book b ORDER BY price ASC")
                .getResultList();
    }
}
