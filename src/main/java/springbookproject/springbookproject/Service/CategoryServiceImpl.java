package springbookproject.springbookproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springbookproject.springbookproject.Dao.CategoryDaoImpl;
import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Category;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDaoImpl categoryDao;

    @Override
    public void create(Category category) {
        categoryDao.create(category);
    }

    @Override
    public void delete(Category category) {
        categoryDao.delete(category);
    }

    @Override
    public void addBook(Book book, Category category) {
        categoryDao.addBook(book, category);
    }

    @Override
    public void deleteBook(Book book, Category category) {
        categoryDao.deleteBook(book, category);
    }

    @Override
    public Category getById(Long id) {
        return categoryDao.getById(id);
    }
}
