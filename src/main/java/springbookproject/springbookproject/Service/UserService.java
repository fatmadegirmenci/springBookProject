package springbookproject.springbookproject.Service;

import springbookproject.springbookproject.Domain.Cart;
import springbookproject.springbookproject.Domain.User;

public interface UserService {

    public void create(User user, Cart cart);
    public void delete(User user);
    public User getById(Long id);
    public boolean checkUserName(String userName);
    public boolean checkParola(String userName, int parola);
    public User getByUserName(String userName);

    }
