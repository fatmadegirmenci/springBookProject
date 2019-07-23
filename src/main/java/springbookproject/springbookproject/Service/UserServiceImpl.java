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
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public boolean checkUserName(String userName) {
        return userDao.checkUserName(userName);
    }

    @Override
    public boolean checkParola(String userName, int parola) {
        return userDao.checkParola(userName, parola);
    }

    @Override
    public User getByUserName(String userName) {
        return userDao.getByUserName(userName);
    }
}
