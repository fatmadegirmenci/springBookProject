package springbookproject.springbookproject.Dao;

import org.springframework.stereotype.Repository;
import springbookproject.springbookproject.Beans.Author;
import springbookproject.springbookproject.Beans.Book;
import springbookproject.springbookproject.Beans.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public void create(Author author) {
        try {
            entityManager.persist(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Author author) {
        try {
            if(entityManager.contains(author)) {
                entityManager.remove(author);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBook(Book book, Author author) {
        try {
            author.getBook().add(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(Book book, Author author) {
        try {
            book.getAuthor().remove(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Author getById(Long id) {
        return (Author) entityManager.find(Author.class, id);
    }

  /*  public Author getByBook(String book_name) {
        return (Author) entityManager.createQuery("SELECT a FROM Author a WHERE ")
    }*/

    public List getBookList(Long user_id) {
        //return entityManager.createQuery("SELECT c FROM chart_book_list_table c").getResultList();

        return  entityManager.createNativeQuery("SELECT b FROM Book b, book_chart c WHERE c.user_id = :user_id" +
                "AND b.book_id = c.book_id")
                .setParameter("user_id", user_id).getResultList();
    }

}
