package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Inventory;
import springbookproject.springbookproject.Model.BookModel;
import springbookproject.springbookproject.Service.InventoryServiceImpl;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/inventory")
@Transactional
public class InventoryController {

    @Autowired
    InventoryServiceImpl inventoryService;

    @PostMapping(value = "/addBook")
    public String addBook(@RequestBody BookModel bookModel) {
        try {
            Book book = new Book(bookModel.getBookName(), bookModel.getCode(), bookModel.getPublishDate(),
                    bookModel.getPrice(), bookModel.getUpdateDate(), bookModel.getAuthor(),
                    bookModel.getCategory(), bookModel.getCart(), bookModel.getInventory());

            inventoryService.addBook(book);

            return "inventory addbook basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "inventory addbook basarisiz";
    }

    @PostMapping(value = "/deleteBook")
    public String deleteBook(@RequestBody BookModel bookModel) {
        try {
            inventoryService.deleteBook(bookModel.getInventory().getBook());
            return "inventory deletebook basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "inventory deletebook basarisiz";
    }

    @GetMapping(value = "/getId/{id}")
    public Inventory getById(@PathVariable Long id) {
        return inventoryService.getById(id);
    }

    @PostMapping(value = "/setBookCount/{bookId}/{numberOfBook}")
    public void setBookCount(@PathVariable Long bookId, @PathVariable int numberOfBook) {
        inventoryService.setBookCount(bookId, numberOfBook);
    }

    @PostMapping(value = "/decreaseBookCount/{book_id}")
    public void decreaseBookCount(@PathVariable Long book_id) {
        inventoryService.decreaseBookCount(book_id);
    }

    @PostMapping(value = "/increaseBookCount/{book_id}")
    public void increaseBookCount(@PathVariable Long book_id) {
        inventoryService.increaseBookCount(book_id);
    }

}
