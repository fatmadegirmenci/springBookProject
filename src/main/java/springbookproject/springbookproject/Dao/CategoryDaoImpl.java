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
            entityManager.merge(category);
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
            category.getBook().add(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(Book book, Category category) {
        try {
            category.getBook().remove(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category getById(Long id) {
        return (Category) entityManager.find(Category.class, id);
    }
}
