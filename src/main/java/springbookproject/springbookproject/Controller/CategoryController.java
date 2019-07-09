package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Beans.Category;
import springbookproject.springbookproject.Dao.CategoryDao;
import springbookproject.springbookproject.Model.CategoryModel;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryDao categoryDao;

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

    @GetMapping(value = "/getId/{id}")
    public Category getById(@PathVariable Long id) {
        return (Category) categoryDao.getById(id);
    }



}
