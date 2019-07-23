package springbookproject.springbookproject.Dao;

import springbookproject.springbookproject.Domain.Author;
import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Category;
import java.util.List;

public interface BookDao {

    public void create(Book book);
    public void delete(Book book);
    public Book getById(Long id);
    public List<Book> getByName(String name);
    public List<Book> getByAuthor(Long id);
    public Book getByCode(String code);
    public List<Book> listByPrice();
    public void addAuthor(Book book, Author author);
    public void deleteAuthor(Book book, Author author);
    public void addCategory(Book book, Category category);
    public void deleteCategory(Book book, Category category);
    public List<Book> isExist(Book book);

    }
