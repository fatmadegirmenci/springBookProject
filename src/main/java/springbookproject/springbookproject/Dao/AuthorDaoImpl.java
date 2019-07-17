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
            entityManager.merge(author);
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
            author.getBook().add(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(Book book, Author author) {
        try {
            author.getBook().remove(book);
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
    public List getBookList(Long user_id) {

        return entityManager.createNativeQuery("SELECT b FROM Book b, book_chart c WHERE c.user_id = :user_id" +
                "AND b.book_id = c.book_id")
                .setParameter("user_id", user_id).getResultList();
    }
}


