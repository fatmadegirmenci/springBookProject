package springbookproject.springbookproject.Dao;

import org.springframework.stereotype.Repository;
import springbookproject.springbookproject.Domain.Author;
import springbookproject.springbookproject.Domain.Book;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(Author author) {
        try {
            entityManager.persist(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Author author) {
        try {
            if (entityManager.contains(author)) {
                entityManager.remove(author);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBook(Book book, Author author) {
        try {
            book.getAuthor().add(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(Book book, Author author) {
        try {
            book.getAuthor().remove(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Author getById(Long id) {
        return entityManager.find(Author.class, id);
    }

  /*  public Author getByBook(String book_name) {
        return (Author) entityManager.createQuery("SELECT a FROM Author a WHERE ")
    }*/

    @Override
    public List getBookList(Long authorId) {

        return entityManager.createNativeQuery("SELECT b.book_id FROM book_author b WHERE b.author_id = :authorId")
                .setParameter("authorId", authorId).getResultList();
    }
}


