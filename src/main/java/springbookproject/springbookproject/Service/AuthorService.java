package springbookproject.springbookproject.Service;

import springbookproject.springbookproject.Domain.Author;
import springbookproject.springbookproject.Domain.Book;

import java.util.List;

public interface AuthorService {
    public void create(Author author);

    public void delete(Author author);

    public void addBook(Book book, Author author);

    public void deleteBook(Book book, Author author);

    public Author getById(Long id);

    public List getBookList(Long user_id);
}
