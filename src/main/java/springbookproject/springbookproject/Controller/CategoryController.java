package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Beans.Book;
import springbookproject.springbookproject.Beans.Category;
import springbookproject.springbookproject.Dao.BookDao;
import springbookproject.springbookproject.Dao.CategoryDao;
import springbookproject.springbookproject.Model.CategoryModel;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    BookDao bookDao;

    @PostMapping(value = "/create")
    public String create(@RequestBody CategoryModel categoryModel) {
        try {
            Category category = new Category(categoryModel.getCategory(), categoryModel.getBook());
            categoryDao.create(category);

            return "kategori ekleme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "kategori ekleme basarisiz";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestBody CategoryModel categoryModel) {
        try {
            categoryDao.delete(categoryDao.getById(categoryModel.getId()));
            return "kategori silme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "kategori silme basarisiz";
    }

    @PostMapping(value = "{categoryId}/addBook/{bookId}")
    public String addBook( @PathVariable Long categoryId, @PathVariable Long bookId) {
        try {
            Book book = bookDao.getById(bookId);

            Category category = categoryDao.getById(categoryId);
            //    book.getAuthor().add(author);

            categoryDao.addBook(book, category);

            return "kategoriye kitap ekleme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "kategoriye kitap ekleme basarisiz";
    }

    @PostMapping(value = "{categoryId}/deleteBook/{bookId}")
    public String deleteBook(@PathVariable Long categoryId, @PathVariable Long bookId) {
        try {
            Category category = categoryDao.getById(categoryId);
            Book book = bookDao.getById(bookId);

            categoryDao.deleteBook(book, category);

            return "kategoriden kitap silme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "kategoriden kitap silme basarisiz";
    }

    @GetMapping(value = "/getId/{id}")
    public Category getById(@PathVariable Long id) {
        return (Category) categoryDao.getById(id);
    }



}
