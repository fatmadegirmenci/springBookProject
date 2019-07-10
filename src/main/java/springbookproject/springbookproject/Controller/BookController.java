package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Beans.*;
import springbookproject.springbookproject.Dao.*;
import springbookproject.springbookproject.Model.BookModel;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookDao bookDao;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    InventoryDao inventoryDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ChartDao chartDao;

    @PostMapping(value = "/create")
    public String create(@RequestBody BookModel bookModel) {
        try {
            Book book = new Book(bookModel.getBookName(), bookModel.getCode(), bookModel.getPublishDate(),
                    bookModel.getPrice(), bookModel.getUpdateDate(), bookModel.getAuthor(),
                    bookModel.getCategory(), bookModel.getChart(), bookModel.getInventory());

            Inventory inventory = new Inventory(1, book);
            inventoryDao.create(inventory);
            book.setInventory(inventory);
        /*    User user = userDao.getById(userId);
            Chart chart = user.getChart();

            List<Chart> charts = new ArrayList<Chart>() ;
            charts.add(chart);

           // book.getChart().add(chart);
            book.setChart(charts);*/
            bookDao.create(book);

            for(int i=0; i<book.getAuthor().size(); i++) {
                authorDao.create(book.getAuthor().get(i));
            }

            return "kitap ekleme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "kitap ekleme basarisiz";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestBody BookModel bookModel) {
        try {
            bookDao.delete(bookDao.getById(bookModel.getId()));
            return "kitap silme islemi basarili";
        } catch (Exception e) {
            e.printStackTrace();
            return "kitap silme islemi basarisiz";
        }
    }

    @GetMapping(value = "/getId/{id}")
    public Book getById(@PathVariable Long id) {
        return bookDao.getById(id);
    }

    @GetMapping(value = "/getName/{name}")
    public List<Book> getByName(@PathVariable String name) {
        return (List<Book>) bookDao.getByName(name);
    }

    @GetMapping(value = "/getAuthor/{authorId}")
    public List<Book> getByAuthor(@PathVariable Long authorId) {
        return bookDao.getByAuthor(authorId);
    }

    @GetMapping(value = "/getCode/{code}")
    public Book getByCode(@PathVariable String code) {
        return bookDao.getByCode(code);
    }

    @GetMapping(value = "/listPrice")
    public Book listByPrice() {
        return bookDao.listByPrice();
    }
}
