package springbookproject.springbookproject.Service;

import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Cart;
import springbookproject.springbookproject.Domain.User;

import java.util.List;

public interface UserService {

    public void create(User user, Cart cart);

    public void delete(User user, List<Book> books);

    public User getById(Long id);
}
