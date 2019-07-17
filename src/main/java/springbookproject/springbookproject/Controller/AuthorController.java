package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Domain.Author;
import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Model.AuthorModel;
import springbookproject.springbookproject.Service.AuthorServiceImpl;
import springbookproject.springbookproject.Service.BookServiceImpl;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/author")
@Transactional
public class AuthorController {

    @Autowired
    AuthorServiceImpl authorService;

    @Autowired
    BookServiceImpl bookService;

    @PostMapping("/create")
    public String create(@RequestBody AuthorModel authorModel) {
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

    @PostMapping("/delete")
    public String delete(@RequestBody AuthorModel authorModel) {
        try {
            authorService.delete(authorService.getById(authorModel.getId()));

            return "author silindi";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "author silinemedi";
    }

    @PostMapping(value = "{authorId}/addBook/{bookId}")
    public String addBook(@PathVariable Long authorId, @PathVariable Long bookId) {
        try {
            Book book = bookService.getById(bookId);

            Author author = authorService.getById(authorId);
            //    book.getAuthor().add(author);

            authorService.addBook(book, author);

            return "yazara kitap ekleme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "yazara kitap ekleme basarisiz";
    }

    @PostMapping(value = "{authorId}/deleteBook/{book_id}")
    public String deleteBook(@PathVariable Long authorId, @PathVariable Long book_id) {
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

    @GetMapping(value = "/getId/{id}")
    public Author getById(@PathVariable Long id) {
        return authorService.getById(id);
    }
}
