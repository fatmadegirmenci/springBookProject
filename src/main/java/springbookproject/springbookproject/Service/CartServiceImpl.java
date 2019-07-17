package springbookproject.springbookproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springbookproject.springbookproject.Dao.CartDaoImpl;
import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Cart;
import springbookproject.springbookproject.Domain.User;
import java.util.List;

@Component
public class CartServiceImpl implements CartService {

    @Autowired
    CartDaoImpl cartDao;

    @Override
    public void create(Cart cart) {
        cartDao.create(cart);
    }

    @Override
    public void addBook(Book book, User user) {
        cartDao.addBook(book, user);
    }

    @Override
    public void deleteBook(Book book) {
        cartDao.deleteBook(book);
    }

    @Override
    public Cart getById(Long id) {
        return cartDao.getById(id);
    }

    @Override
    public List<Book> getBookList(User user) {
        return cartDao.getBookList(user);
    }

    @Override
    public List<Cart> getByUser(Long userId) {
        return cartDao.getByUser(userId);
    }

    @Override
    public int getTotalPriceByUser(Long userId) {
        return cartDao.getTotalPriceByUser(userId);
    }
}
