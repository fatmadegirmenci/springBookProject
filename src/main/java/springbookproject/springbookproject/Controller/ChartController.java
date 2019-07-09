package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Beans.Book;
import springbookproject.springbookproject.Beans.Chart;
import springbookproject.springbookproject.Beans.User;
import springbookproject.springbookproject.Dao.BookDao;
import springbookproject.springbookproject.Dao.ChartDao;
import springbookproject.springbookproject.Dao.UserDao;
import springbookproject.springbookproject.Model.BookModel;
import springbookproject.springbookproject.Model.UserModel;

import java.util.List;

@RestController
@RequestMapping("/chart")
public class ChartController {

    @Autowired
    ChartDao chartDao;

    @Autowired
    UserDao userDao;

    @PostMapping(value = "/addBook")
    public String addBook(@RequestBody BookModel bookModel, @RequestBody UserModel userModel) {
        try {
            Book book = new Book(bookModel.getBookName(), bookModel.getCode(), bookModel.getPublishDate(),
                    bookModel.getPrice(), bookModel.getUpdateDate(), bookModel.getAuthor(),
                    bookModel.getCategory(), bookModel.getInventory());

            User user = new User(userModel.getFirstName(), userModel.getLastName(),
                    userModel.getRegisterDate(), userModel.getAddress(), userModel.getChart());

            chartDao.addBook(book, user);
            return "sepete kitap ekleme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "sepete kitap ekleme basarisiz";
    }

    @PostMapping(value = "/deleteBook")
    public String deleteBook(@RequestBody List<BookModel> bookModel, @RequestBody UserModel userModel ){
        try {
            chartDao.deleteBook(chartDao.getById(userModel.getId()).getBook(), chartDao.getById(userModel.getId()).getUser());
            return "sepetten kitap silme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "sepetten kitap silme basarisiz";
    }

    @GetMapping("/getId/{id}")
    public Chart getById(@PathVariable Long id) {
        return chartDao.getById(id);
    }

    @GetMapping("/getTotalPrice/{id}")
    public int getTotalPrice(@PathVariable Long id) {
        return chartDao.getTotalPrice(id);
    }
}
