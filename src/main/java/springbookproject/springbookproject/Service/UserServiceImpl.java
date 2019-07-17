package springbookproject.springbookproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springbookproject.springbookproject.Dao.UserDaoImpl;
import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Cart;
import springbookproject.springbookproject.Domain.User;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserDaoImpl userDao;

    @Override
    public void create(User user, Cart cart) {
        userDao.create(user, cart);
    }

    @Override
    public void delete(User user, List<Book> books) {
        userDao.delete(user, books);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }
}
