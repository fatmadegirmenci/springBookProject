package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Inventory;
import springbookproject.springbookproject.Model.BookModel;
import springbookproject.springbookproject.Model.UserModel;
import springbookproject.springbookproject.Service.BookServiceImpl;
import springbookproject.springbookproject.Service.InventoryServiceImpl;
import springbookproject.springbookproject.Service.UserServiceImpl;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/inventory")
@Transactional
public class InventoryController {

    @Autowired
    InventoryServiceImpl inventoryService;
    @Autowired
    BookServiceImpl bookService;
    @Autowired
    UserServiceImpl userService;

    @PostMapping(value = "/addBook")
    public String addBook(@RequestBody BookModel bookModel) {
        String role = userService.getByUserName(bookModel.getUserName()).getRole();

        if (role.equalsIgnoreCase("admin")) {
            try {
                Book book = bookService.getById(bookModel.getId());
                inventoryService.increaseBookCount(book.getId());

                return "inventory addbook basarili";
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "inventory addbook basarisiz";
        }
        return "yetki yok";
    }

    @PostMapping(value = "/deleteBook")
    public String deleteBook(@RequestBody BookModel bookModel) {
        String role = userService.getByUserName(bookModel.getUserName()).getRole();

        if (role.equalsIgnoreCase("admin")) {
            try {

                Book book = bookService.getById(bookModel.getId());

                if (book.getInventory().getNumberOfBook() == 1)
                    bookService.delete(book);
                else
                    inventoryService.decreaseBookCount(book.getId());

                return "inventory deletebook basarili";
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "inventory deletebook basarisiz";
        }
        return "yetki yok";
    }

    @GetMapping(value = "/getId/{id}")
    public Inventory getById(@PathVariable Long id) {
        return inventoryService.getById(id);
    }

    @PostMapping(value = "/setBookCount/{bookId}/{numberOfBook}")
    public String  setBookCount(@RequestBody UserModel userModel, @PathVariable Long bookId, @PathVariable int numberOfBook) {
        String role = userService.getByUserName(userModel.getUserName()).getRole();

        if (role.equalsIgnoreCase("admin")) {
            inventoryService.setBookCount(bookId, numberOfBook);
            return (bookId+" kitabi " + numberOfBook + " tane olarak degistirildi");
        } else {
            return "yetki yok";
        }
    }

    @PostMapping(value = "/decreaseBookCount/{book_id}")
    public String decreaseBookCount(@RequestBody UserModel userModel, @PathVariable Long book_id) {
        String role = userService.getByUserName(userModel.getUserName()).getRole();

        if (role.equalsIgnoreCase("admin")) {
            inventoryService.decreaseBookCount(book_id);
            return (book_id +" kitabi bir azaltildi");

        } else {
            return "yetki yok";
        }

    }

    @PostMapping(value = "/increaseBookCount/{book_id}")
    public String  increaseBookCount(@RequestBody UserModel userModel, @PathVariable Long book_id) {
        String role = userService.getByUserName(userModel.getUserName()).getRole();

        if (role.equalsIgnoreCase("admin")) {
            inventoryService.increaseBookCount(book_id);
            return (book_id +" kitabi bir artirildi");
        } else {
            return "yetki yok";
        }
    }
}
