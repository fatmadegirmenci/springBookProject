package springbookproject.springbookproject.Service;

import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Category;

public interface CategoryService {

    public void create(Category category);

    public void delete(Category category);

    public void addBook(Book book, Category category);

    public void deleteBook(Book book, Category category);

    public Category getById(Long id);
}
