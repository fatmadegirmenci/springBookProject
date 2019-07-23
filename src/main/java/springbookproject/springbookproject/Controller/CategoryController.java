package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Category;
import springbookproject.springbookproject.Domain.User;
import springbookproject.springbookproject.Model.CategoryModel;
import springbookproject.springbookproject.Model.UserModel;
import springbookproject.springbookproject.Service.BookServiceImpl;
import springbookproject.springbookproject.Service.CategoryServiceImpl;
import springbookproject.springbookproject.Service.UserService;
import springbookproject.springbookproject.Service.UserServiceImpl;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/category")
@Transactional
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryService;

    @Autowired
    BookServiceImpl bookService;

    @Autowired
    UserServiceImpl userService;

    @PostMapping(value = "/create")
    public String create(@RequestBody CategoryModel categoryModel) {
        String role = userService.getByUserName(categoryModel.getUserName()).getRole();

        if (role.equalsIgnoreCase("admin")) {
            try {
                Category category = new Category(categoryModel.getCategory(), categoryModel.getBook());
                categoryService.create(category);

                return "kategori ekleme basarili";
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "kategori ekleme basarisiz";
        }
        return "yetki yok";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestBody CategoryModel categoryModel) {
        String role = userService.getByUserName(categoryModel.getUserName()).getRole();

        if (role.equalsIgnoreCase("admin")) {
            try {
                categoryService.delete(categoryService.getById(categoryModel.getId()));
                return "kategori silme basarili";
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "kategori silme basarisiz";
        }
        return "yetki yok";
    }

    @PostMapping(value = "{categoryId}/addBook/{bookId}")
    public String addBook(@RequestBody UserModel userModel, @PathVariable Long categoryId, @PathVariable Long bookId) {
        String role = userService.getByUserName(userModel.getUserName()).getRole();

        if (role.equalsIgnoreCase("admin")) {
            try {
                Book book = bookService.getById(bookId);
                Category category = categoryService.getById(categoryId);
                categoryService.addBook(book, category);

                return "kategoriye kitap ekleme basarili";
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "kategoriye kitap ekleme basarisiz";
        }
        return "yetki yok";
    }

    @PostMapping(value = "{categoryId}/deleteBook/{bookId}")
    public String deleteBook(@RequestBody UserModel userModel, @PathVariable Long categoryId, @PathVariable Long bookId) {
        String role = userService.getByUserName(userModel.getUserName()).getRole();

        if (role.equalsIgnoreCase("admin")) {
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
        return "yetki yok";
    }

    @GetMapping(value = "/getId/{id}")
    public Category getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }


}
