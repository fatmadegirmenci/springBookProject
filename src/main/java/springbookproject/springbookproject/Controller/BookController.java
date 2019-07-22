package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Domain.*;
import springbookproject.springbookproject.Model.BookModel;
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

    @PostMapping(value = "/create")
    public String create(@RequestBody BookModel bookModel) {
        try {
            Book book = new Book(bookModel.getBookName(), bookModel.getCode(), bookModel.getPublishDate(),
                    bookModel.getPrice(), bookModel.getUpdateDate(), bookModel.getAuthor(),
                    bookModel.getCategory(), bookModel.getCart(), bookModel.getInventory());

            if(bookService.isExist(book) == null) {
                Inventory inventory = new Inventory(1, book);
                // inventoryService.create(inventory);

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

    @PostMapping(value = "/delete")
    public String delete(@RequestBody BookModel bookModel) {
        try {
            Book book = bookService.getById(bookModel.getId());
            if(book.getInventory().getNumberOfBook() == 1) {
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

    @PostMapping(value = "{bookId}/addAuthor/{authorId}")
    public String addAuthor(@PathVariable Long bookId, @PathVariable Long authorId) {
        try {
            Book book = bookService.getById(bookId);

            Author author = authorService.getById(authorId);
            //    book.getAuthor().add(author);

            bookService.addAuthor(book, author);

            return "kitaba yazar ekleme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "kitaba yazar ekleme basarisiz";
    }

    @PostMapping(value = "{bookId}/deleteAuthor/{authorId}")
    public String deleteAuthor(@PathVariable Long bookId, @PathVariable Long authorId) {
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

    @PostMapping(value = "{bookId}/addCategory/{categoryId}")
    public String addCategory(@PathVariable Long bookId, @PathVariable Long categoryId) {
        try {
            Book book = bookService.getById(bookId);

            Category category = categoryService.getById(categoryId);
            //    book.getAuthor().add(author);

            bookService.addCategory(book, category);

            return "kitaba kategori ekleme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "kitaba kategori ekleme basarisiz";
    }

    @PostMapping(value = "{bookId}/deleteCategory/{categoryId}")
    public String deleteCategory(@PathVariable Long bookId, @PathVariable Long categoryId) {
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
