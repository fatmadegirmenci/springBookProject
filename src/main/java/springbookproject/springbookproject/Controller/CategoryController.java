package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Category;
import springbookproject.springbookproject.Model.CategoryModel;
import springbookproject.springbookproject.Service.BookServiceImpl;
import springbookproject.springbookproject.Service.CategoryServiceImpl;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/category")
@Transactional
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryService;

    @Autowired
    BookServiceImpl bookService;

    @PostMapping(value = "/create")
    public String create(@RequestBody CategoryModel categoryModel) {
        try {
            Category category = new Category(categoryModel.getCategory(), categoryModel.getBook());
            categoryService.create(category);

            return "kategori ekleme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "kategori ekleme basarisiz";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestBody CategoryModel categoryModel) {
        try {
            categoryService.delete(categoryService.getById(categoryModel.getId()));
            return "kategori silme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "kategori silme basarisiz";
    }

    @PostMapping(value = "{categoryId}/addBook/{bookId}")
    public String addBook(@PathVariable Long categoryId, @PathVariable Long bookId) {
        try {
            Book book = bookService.getById(bookId);

            Category category = categoryService.getById(categoryId);
            //    book.getAuthor().add(author);

            categoryService.addBook(book, category);

            return "kategoriye kitap ekleme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "kategoriye kitap ekleme basarisiz";
    }

    @PostMapping(value = "{categoryId}/deleteBook/{bookId}")
    public String deleteBook(@PathVariable Long categoryId, @PathVariable Long bookId) {
        try {
            Category category = categoryService.getById(categoryId);
            Book book = bookService.getById(bookId);

            categoryService.deleteBook(book, category);

            return "kategoriden kitap silme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "kategoriden kitap silme basarisiz";
    }

    @GetMapping(value = "/getId/{id}")
    public Category getById(@PathVariable Long id) {
        return (Category) categoryService.getById(id);
    }


}
