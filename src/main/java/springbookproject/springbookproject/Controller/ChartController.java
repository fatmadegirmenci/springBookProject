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

    @Autowired
    BookDao bookDao;

    @PostMapping(value = "{userId}/addBook/{bookId}")
    public String addBook(@PathVariable Long userId, @PathVariable Long bookId) {
        try {
            Book book = bookDao.getById(bookId);
            User user = userDao.getById(userId);

            chartDao.addBook(book, user);
            //chartDao.addBook(book, userDao.);
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

    @RequestMapping(value = "/getList/{user_id}/list", method = RequestMethod.GET)
    public List<Book> getBookList(@PathVariable Long user_id) {
        //return entityManager.createQuery("SELECT c FROM chart_book_list_table c").getResultList();

        return  chartDao.getBookList(user_id);
    }
}
