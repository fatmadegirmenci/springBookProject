package springbookproject.springbookproject.Dao;

import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Cart;
import springbookproject.springbookproject.Domain.User;

import java.util.List;

public interface CartDao {

    public void create(Cart cart);


    public void addBook(Book book, User user);

    public void deleteBook(Book book);

    public Cart getById(Long id);

    public List<Book> getBookList(User user);

    public List<Cart> getByUser(Long userId);

    public int getTotalPriceByUser(Long userId);
}
