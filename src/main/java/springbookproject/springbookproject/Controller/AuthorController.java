package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Beans.Author;
import springbookproject.springbookproject.Beans.Book;
import springbookproject.springbookproject.Dao.AuthorDao;
import springbookproject.springbookproject.Dao.BookDao;
import springbookproject.springbookproject.Model.AuthorModel;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorDao authorDao;

    @Autowired
    BookDao bookDao;

    @PostMapping("/create")
    public String create(@RequestBody AuthorModel authorModel) {
        try {
            Author author = new Author(authorModel.getFirstName(), authorModel.getLastName(), authorModel.getCountry(),
                    authorModel.getBook());
            authorDao.create(author);

         //   for(int i=0; i<author.getBook().size(); i++) {
           //     bookDao.create(author.getBook().get(i));
            //}

            return "author olusturuldu";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "author olustururken hata";
    }

    @PostMapping("/delete")
    public String delete(@RequestBody AuthorModel authorModel) {
        try {
            authorDao.delete(authorDao.getById(authorModel.getId()));

            return "author silindi";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "author silinemedi";
    }

    @PostMapping(value = "{authorId}/addBook/{bookId}")
    public String addBook(@PathVariable Long authorId, @PathVariable Long bookId) {
        try {
            Book book = bookDao.getById(bookId);

            Author author = authorDao.getById(authorId);
        //    book.getAuthor().add(author);

            authorDao.addBook(book, author);

            return "yazara kitap ekleme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "yazara kitap ekleme basarisiz";
    }

    @PostMapping(value = "{authorId}/deleteBook/{book_id}")
    public String deleteBook(@PathVariable Long authorId, @PathVariable Long book_id) {
        try {
            Author author = authorDao.getById(authorId);
            Book book = bookDao.getById(book_id);

            authorDao.deleteBook(book, author);

            return "yazardan kitap silme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "yazardan kitap silme basarisiz";
    }

    @GetMapping(value = "/getId/{id}")
    public Author getById(@PathVariable Long id) {
        return authorDao.getById(id);
    }
  //  @GetMapping(value = "getBook/")
   // public Author getByBook

}
