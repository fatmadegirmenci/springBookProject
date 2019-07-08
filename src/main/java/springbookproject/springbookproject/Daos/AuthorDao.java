package springbookproject.springbookproject.Daos;

import org.springframework.stereotype.Repository;
import springbookproject.springbookproject.Beans.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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

  /*  public Author getByBook(String book_name) {
        return (Author) entityManager.createQuery("SELECT a FROM Author a WHERE ")
    }*/

}
