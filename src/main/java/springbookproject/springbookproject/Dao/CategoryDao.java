package springbookproject.springbookproject.Dao;

import org.springframework.stereotype.Repository;
import springbookproject.springbookproject.Beans.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public void create(Category category) {
        try {
            entityManager.persist(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Category category) {
        try {
            if(entityManager.contains(category)) {
                entityManager.remove(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Category getById(Long id) {
        return (Category) entityManager.find(Category.class, id);
    }
}
