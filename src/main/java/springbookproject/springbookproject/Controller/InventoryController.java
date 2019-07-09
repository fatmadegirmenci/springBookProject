package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Beans.Book;
import springbookproject.springbookproject.Beans.Inventory;
import springbookproject.springbookproject.Dao.InventoryDao;
import springbookproject.springbookproject.Model.BookModel;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryDao inventoryDao;

    @PostMapping(value = "/addBook")
    public String addBook(@RequestBody BookModel bookModel) {
        try {
            Book book = new Book(bookModel.getBookName(), bookModel.getCode(), bookModel.getPublishDate(),
                    bookModel.getPrice(), bookModel.getUpdateDate(), bookModel.getAuthor(),
                    bookModel.getCategory(), bookModel.getInventory());

            inventoryDao.addBook(book);

            return "inventory addbook basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "inventory addbook basarisiz";
    }

    @PostMapping(value = "/deleteBook")
    public String deleteBook(@RequestBody BookModel bookModel) {
        try {
            //inventoryDao.deleteBook(bookModel.getInventory().getBook()));
            return "inventory deletebook basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "inventory deletebook basarisiz";
    }

    @GetMapping(value = "/getId/{id}")
    public Inventory getById(@PathVariable Long id) {
        return inventoryDao.getById(id);
    }

    @GetMapping(value = "/setBookCount")
    public void setBookCount(Long book_id, int bookCount) {
        inventoryDao.setBookCount(book_id, bookCount);
    }

    @GetMapping(value = "/decreaseBookCount")
    public void decreaseBookCount(Long book_id) {
        inventoryDao.decreaseBookCount(book_id);
    }
    @GetMapping(value = "/increaseBookCount")
    public void increaseBookCount(Long book_id) {
        inventoryDao.increaseBookCount(book_id);
    }


}
