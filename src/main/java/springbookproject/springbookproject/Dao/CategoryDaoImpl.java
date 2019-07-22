package springbookproject.springbookproject.Dao;

import org.springframework.stereotype.Repository;
import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(Category category) {
        try {
            entityManager.persist(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Category category) {
        try {
            if(entityManager.contains(category)) {
                entityManager.remove(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBook(Book book, Category category) {
        try {
           // book.getCategory().add(category);
            category.getBook().add(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(Book book, Category category) {
        try {
      //      int i;
              category.getBook().remove(book);
    //        category.getBook().remove(book);
         //   book.getCategory().remove(category);
       //     category.getBook().remove(book);
          //  for(i=0; i<category.getBook().size(); i++) {
         //       if(category.getBook().get(i) == book) {
         //           break;
         //       }
         //   }
      //      entityManager.remove(category.getBook().get(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category getById(Long id) {
        return (Category) entityManager.find(Category.class, id);
    }
}
