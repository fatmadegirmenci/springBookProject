package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Domain.Author;
import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Model.AuthorModel;
import springbookproject.springbookproject.Model.UserModel;
import springbookproject.springbookproject.Service.AuthorServiceImpl;
import springbookproject.springbookproject.Service.BookServiceImpl;
import springbookproject.springbookproject.Service.UserServiceImpl;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/author")
@Transactional
public class AuthorController {

    @Autowired
    AuthorServiceImpl authorService;

    @Autowired
    BookServiceImpl bookService;

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/create")
    public String create(@RequestBody AuthorModel authorModel) {
        String role = userService.getByUserName(authorModel.getUserName()).getRole();

        if (role.equalsIgnoreCase("admin")) {
            try {
                Author author = new Author(authorModel.getFirstName(), authorModel.getLastName(), authorModel.getCountry(),
                        authorModel.getBook());
                authorService.create(author);
                return "author olusturuldu";
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "author olustururken hata";
        }
        return "yetki yok";
    }

    @PostMapping("/delete")
    public String delete(@RequestBody AuthorModel authorModel) {
        String role = userService.getByUserName(authorModel.getUserName()).getRole();

        if (role.equalsIgnoreCase("admin")) {
            try {
                authorService.delete(authorService.getById(authorModel.getId()));

                return "author silindi";
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "author silinemedi";
        }
        return "yetki yok";
    }

    @PostMapping(value = "{authorId}/addBook/{bookId}")
    public String addBook(@RequestBody UserModel userModel, @PathVariable Long authorId, @PathVariable Long bookId) {
        String role = userService.getByUserName(userModel.getUserName()).getRole();

        if (role.equalsIgnoreCase("admin")) {
            try {
                Book book = bookService.getById(bookId);
                Author author = authorService.getById(authorId);
                authorService.addBook(book, author);

                return "yazara kitap ekleme basarili";
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "yazara kitap ekleme basarisiz";
        }
        return "yetki yok";
    }

    @PostMapping(value = "{authorId}/deleteBook/{book_id}")
    public String deleteBook(@RequestBody UserModel userModel, @PathVariable Long authorId, @PathVariable Long book_id) {
        String role = userService.getByUserName(userModel.getUserName()).getRole();

        if (role.equalsIgnoreCase("admin")) {
            try {
                Author author = authorService.getById(authorId);
                Book book = bookService.getById(book_id);
                authorService.deleteBook(book, author);

                return "yazardan kitap silme basarili";
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "yazardan kitap silme basarisiz";
        }
        return "yetki yok";
    }


    @GetMapping(value = "/getId/{id}")
    public Author getById(@PathVariable Long id) {
        return authorService.getById(id);
    }

    @GetMapping(value = "{authorId}/getBookList")
    public List getBookList(@PathVariable Long authorId) {
        return authorService.getBookList(authorId);
    }

}
