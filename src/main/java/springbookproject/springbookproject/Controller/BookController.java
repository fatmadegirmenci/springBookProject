package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Beans.Book;
import springbookproject.springbookproject.Dao.BookDao;
import springbookproject.springbookproject.Model.BookModel;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookDao bookDao;

    @PostMapping(value = "/create")
    public String create(@RequestBody BookModel bookModel) {
        try {
            Book book = new Book(bookModel.getBookName(), bookModel.getCode(), bookModel.getPublishDate(),
                    bookModel.getPrice(), bookModel.getUpdateDate(), bookModel.getAuthor(),
                    bookModel.getCategory(), bookModel.getInventory());
            bookDao.create(book);
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
        }

        return "kitap silme islemi basarili";
    }

    @GetMapping(value = "/getId/{id}")
    public Book getById(@PathVariable Long id) {
        return bookDao.getById(id);
    }

    @GetMapping(value = "/getName/{name}")
    public Book getByName(@PathVariable String name) {
        return bookDao.getByName(name);
    }

    @GetMapping(value = "/getAuthor/{author}")
    public Book getByAuthor(@PathVariable String author) {
        return bookDao.getByAuthor(author);
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
