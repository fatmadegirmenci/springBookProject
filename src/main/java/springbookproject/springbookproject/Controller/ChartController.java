package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Beans.Book;
import springbookproject.springbookproject.Beans.Chart;
import springbookproject.springbookproject.Beans.User;
import springbookproject.springbookproject.Dao.BookDao;
import springbookproject.springbookproject.Dao.ChartDao;
import springbookproject.springbookproject.Dao.UserDao;
import springbookproject.springbookproject.Model.BookModel;
import springbookproject.springbookproject.Model.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chart")
public class ChartController {

    @Autowired
    ChartDao chartDao;

    @Autowired
    UserDao userDao;

    @Autowired
    BookDao bookDao;

    @PostMapping(value = "{chartId}/addBook/{bookId}")
    public String addBook(@PathVariable Long chartId, @PathVariable Long bookId) {
        try {
            Book book = bookDao.getById(bookId);
            User user = chartDao.getById(chartId).getUser();

            Chart chart = user.getChart();

          //  List<Chart> charts = new ArrayList<Chart>() ;
           // charts.add(chart);

            // book.getChart().add(chart);
            book.getChart().add(chart);

            chartDao.addBook(book, user);
            //chartDao.addBook(book, userDao.);
            return "sepete kitap ekleme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "sepete kitap ekleme basarisiz";
    }

    @PostMapping(value = "{chartId}/deleteBook/{book_id}")
    public String deleteBook(@PathVariable Long chartId, @PathVariable Long book_id) {
        try {
            Book book = bookDao.getById(book_id);
            chartDao.deleteBook(book);

            return "sepetten kitap silme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "kitap silme basarisiz";
    }

   /* @PostMapping(value = "/deleteBook/{book_id}")
    public String deleteBook(@RequestBody List<BookModel> bookModel, @RequestBody UserModel userModel, @PathVariable Long book_id){
        try {
            //chartDao.deleteBook(chartDao.getById(userModel.getId()).getBook(), chartDao.getById(userModel.getId()).getUser());
            for(int i=0; i< chartDao.getById(userModel.getId()).getBook().size(); i++) {
                if(chartDao.getById(userModel.getId()).getBook().get(i).getId() == book_id) {
                    chartDao.deleteBook(chartDao.getById(userModel.getId()).getBook().get(i), userModel.getChart());
                }
            }

            return "sepetten kitap silme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "sepetten kitap silme basarisiz";
    }
*/
    @GetMapping("/getId/{id}")
    public Chart getById(@PathVariable Long id) {
        return chartDao.getById(id);
    }

   /* @GetMapping("/getTotalPrice/{id}")
    public int getTotalPrice(@PathVariable Long id) {
        return chartDao.getTotalPrice(id);
    }
*/
    @RequestMapping(value = "/getList/{user_id}/list", method = RequestMethod.GET)
    public List<Book> getBookList(@PathVariable Long user_id) {
        //return entityManager.createQuery("SELECT c FROM chart_book_list_table c").getResultList();

        return  chartDao.getBookList(userDao.getById(user_id));
    }

    @GetMapping(value = "/getChart/{id}")
    public List<Chart> getByUser(@PathVariable Long id) {
        return chartDao.getByUser(id);
    }

    @RequestMapping(value = "/getTotalPrice/{userId}", method = RequestMethod.GET)
    public int getTotalPriceByUser(@PathVariable Long userId) {
        return chartDao.getTotalPriceByUser(userId);
    }
}
