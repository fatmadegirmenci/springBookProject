package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Cart;
import springbookproject.springbookproject.Domain.User;
import springbookproject.springbookproject.Service.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/cart")
@Transactional
public class CartController {

    @Autowired
    CartServiceImpl cartService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    BookServiceImpl bookService;

    @PostMapping(value = "{cartId}/addBook/{bookId}")
    public String addBook(@PathVariable Long cartId, @PathVariable Long bookId) {
        try {
            Book book = bookService.getById(bookId);
            User user = cartService.getById(cartId).getUser();
            Cart cart = user.getCart();

            int totalPrice = cart.getTotalPrice() + bookService.getById(bookId).getPrice();
            cart.setTotalPrice(totalPrice);
            cartService.addBook(book, user);

            return "sepete kitap ekleme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "sepete kitap ekleme basarisiz";
    }

    @PostMapping(value = "{cartId}/deleteBook/{book_id}")
    public String deleteBook(@PathVariable Long cartId, @PathVariable Long book_id) {
        try {
            Book book = bookService.getById(book_id);
            Cart cart = cartService.getById(cartId);
            int totalPrice = cart.getTotalPrice() - bookService.getById(book_id).getPrice();
            cart.setTotalPrice(totalPrice);
            cartService.deleteBook(book, cart);

            return "sepetten kitap silme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "kitap silme basarisiz";
    }

    @GetMapping("/getId/{id}")
    public Cart getById(@PathVariable Long id) {
        return cartService.getById(id);
    }

    @RequestMapping(value = "/getList/{user_id}/list", method = RequestMethod.GET)
    public List<Book> getBookList(@PathVariable Long user_id) {
        return cartService.getBookList(userService.getById(user_id));
    }

    @GetMapping(value = "/getCart/{id}")
    public List<Cart> getByUser(@PathVariable Long id) {
        return cartService.getByUser(id);
    }

    @RequestMapping(value = "/getTotalPrice/{userId}", method = RequestMethod.GET)
    public int getTotalPriceByUser(@PathVariable Long userId) {
        return cartService.getTotalPriceByUser(userId);
    }
}
