package springbookproject.springbookproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springbookproject.springbookproject.Dao.AuthorDaoImpl;
import springbookproject.springbookproject.Domain.Author;
import springbookproject.springbookproject.Domain.Book;
import java.util.List;

@Component
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    AuthorDaoImpl authorDao;

    @Override
    public void create(Author author) {
        authorDao.create(author);
    }

    @Override
    public void delete(Author author) {
        authorDao.delete(author);
    }

    @Override
    public void addBook(Book book, Author author) {
        authorDao.addBook(book, author);
    }

    @Override
    public void deleteBook(Book book, Author author) {
        authorDao.deleteBook(book, author);
    }

    @Override
    public Author getById(Long id) {
        return authorDao.getById(id);
    }

    @Override
    public List getBookList(Long user_id) {
        return authorDao.getBookList(user_id);
    }
}
