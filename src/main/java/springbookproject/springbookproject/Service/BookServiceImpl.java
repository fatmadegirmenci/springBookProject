package springbookproject.springbookproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springbookproject.springbookproject.Dao.BookDaoImpl;
import springbookproject.springbookproject.Domain.Author;
import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Category;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    BookDaoImpl bookDao;

    @Override
    public void create(Book book) {
        bookDao.create(book);
    }

    @Override
    public void delete(Book book) {
        bookDao.delete(book);
    }

    @Override
    public Book getById(Long id) {
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getByName(String name) {
        return bookDao.getByName(name);
    }

    @Override
    public List<Book> getByAuthor(Long id) {
        return bookDao.getByAuthor(id);
    }

    @Override
    public Book getByCode(String code) {
        return bookDao.getByCode(code);
    }

    @Override
    public List<Book> listByPrice() {
        return bookDao.listByPrice();
    }

    @Override
    public void addAuthor(Book book, Author author) {
        bookDao.addAuthor(book, author);
    }

    @Override
    public void deleteAuthor(Book book, Author author) {
        bookDao.deleteAuthor(book, author);
    }

    @Override
    public void addCategory(Book book, Category category) {
        bookDao.addCategory(book, category);
    }

    @Override
    public void deleteCategory(Book book, Category category) {
        bookDao.deleteCategory(book, category);
    }

    @Override
    public List<Book> isExist(Book book){
        return bookDao.isExist(book);
    }
}
