package springbookproject.springbookproject.Dao;


import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    private static SessionFactory sessionFactory;


    @Override
    public void create(Author author) {
        try {
            entityManager.persist(author);
            //entityManager.flush();
            //entityManager.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Author author) {
        try {
            if (entityManager.contains(author)) {
             //  objAgreement= em.find(Agreement.class, objAgreement.getId())
                //em.remove(objAgreement);

            //    author.getBook().removeAll(author.getBook());
              //  entityManager.remove(author);
 //               entityManager.getTransaction().begin();
                entityManager.remove(author);
   //             entityManager.getTransaction().commit();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBook(Book book, Author author) {
        try {
       //     author.getBook().add(book);
            book.getAuthor().add(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(Book book, Author author) {
        try {
            //author.getBook().remove(book);
            book.getAuthor().remove(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Author getById(Long id) {
     //   Author a =  entityManager.find(Author.class, id);
     //   Hibernate.initialize(a.getBook());
     //   return a;

        return  entityManager.find(Author.class, id);
      //  session.close();
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


