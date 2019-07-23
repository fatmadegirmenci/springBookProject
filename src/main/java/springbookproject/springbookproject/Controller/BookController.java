package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Domain.*;
import springbookproject.springbookproject.Model.BookModel;
import springbookproject.springbookproject.Model.UserModel;
import springbookproject.springbookproject.Service.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/book")
@Transactional
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @Autowired
    AuthorServiceImpl authorService;

    @Autowired
    InventoryServiceImpl inventoryService;

    @Autowired
    CategoryServiceImpl categoryService;

    @Autowired
    UserServiceImpl userService;

    @PostMapping(value = "/create")
    public String create(@RequestBody BookModel bookModel) {
        String role = userService.getByUserName(bookModel.getUserName()).getRole();

        if (role.equalsIgnoreCase("admin")) {
            try {

                Book book = new Book(bookModel.getBookName(), bookModel.getCode(), bookModel.getPublishDate(),
                        bookModel.getPrice(), bookModel.getUpdateDate(), bookModel.getAuthor(),
                        bookModel.getCategory(), bookModel.getCart(), bookModel.getInventory());

                if (bookService.isExist(book) == null) {
                    Inventory inventory = new Inventory(1, book);
                    book.setInventory(inventory);
                    bookService.create(book);
                } else {
                    inventoryService.increaseBookCount(bookService.isExist(book).get(0).getId());
                }

                return "kitap ekleme basarili";
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "kitap ekleme basarisiz";
        }

        return "yetki yok";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestBody BookModel bookModel) {
        String role = userService.getByUserName(bookModel.getUserName()).getRole();

        if (role.equalsIgnoreCase("admin")) {
            try {
                Book book = bookService.getById(bookModel.getId());

                if (book.getInventory().getNumberOfBook() == 1) {
                    bookService.delete(bookService.getById(book.getId()));
                } else {
                    inventoryService.decreaseBookCount(bookService.getById(book.getId()).getId());
                }

                return "kitap silme islemi basarili";
            } catch (Exception e) {
                e.printStackTrace();
                return "kitap silme islemi basarisiz";
            }
        }
        return "yetki yok";
    }

    @PostMapping(value = "{bookId}/addAuthor/{authorId}")
    public String addAuthor(@RequestBody UserModel userModel, @PathVariable Long bookId, @PathVariable Long authorId) {
        String role = userService.getByUserName(userModel.getUserName()).getRole();

        if (role.equalsIgnoreCase("admin")) {
            try {
                Book book = bookService.getById(bookId);
                Author author = authorService.getById(authorId);
                bookService.addAuthor(book, author);

                return "kitaba yazar ekleme basarili";
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "kitaba yazar ekleme basarisiz";
        }
        return "yetki yok";
    }

    @PostMapping(value = "{bookId}/deleteAuthor/{authorId}")
    public String deleteAuthor(@RequestBody UserModel userModel, @PathVariable Long bookId, @PathVariable Long authorId) {
        String role = userService.getByUserName(userModel.getUserName()).getRole();

        if (role.equalsIgnoreCase("admin")) {
            try {
                Author author = authorService.getById(authorId);
                Book book = bookService.getById(bookId);
                bookService.deleteAuthor(book, author);

                return "yazardan kitap silme basarili";
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "yazardan kitap silme basarisiz";
        }
        return "yetki yok";
    }

    @PostMapping(value = "{bookId}/addCategory/{categoryId}")
    public String addCategory(@RequestBody UserModel userModel, @PathVariable Long bookId, @PathVariable Long categoryId) {
        String role = userService.getByUserName(userModel.getUserName()).getRole();

        if (role.equalsIgnoreCase("admin")) {
            try {
                Book book = bookService.getById(bookId);
                Category category = categoryService.getById(categoryId);
                bookService.addCategory(book, category);

                return "kitaba kategori ekleme basarili";
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "kitaba kategori ekleme basarisiz";
        }
        return "yetki yok";
    }

    @PostMapping(value = "{bookId}/deleteCategory/{categoryId}")
    public String deleteCategory(@RequestBody UserModel userModel, @PathVariable Long bookId, @PathVariable Long categoryId) {
        String role = userService.getByUserName(userModel.getUserName()).getRole();

        if (role.equalsIgnoreCase("admin")) {
            try {
                Category category = categoryService.getById(categoryId);
                Book book = bookService.getById(bookId);
                bookService.deleteCategory(book, category);

                return "kitaptan kategori silme basarili";
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "kitaptan kategori silme basarisiz";
        }
        return "yetki yok";
    }

    @GetMapping(value = "/getId/{id}")
    public Book getById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @GetMapping(value = "/getName/{name}")
    public List<Book> getByName(@PathVariable String name) {
        return (List<Book>) bookService.getByName(name);
    }

    @GetMapping(value = "/getAuthor/{authorId}")
    public List<Book> getByAuthor(@PathVariable Long authorId) {
        return bookService.getByAuthor(authorId);
    }

    @GetMapping(value = "/getCode/{code}")
    public Book getByCode(@PathVariable String code) {
        return bookService.getByCode(code);
    }

    @GetMapping(value = "/listPrice")
    public List<Book> listByPrice() {
        return bookService.listByPrice();
    }
}
