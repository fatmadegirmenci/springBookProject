package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Beans.Author;
import springbookproject.springbookproject.Dao.AuthorDao;
import springbookproject.springbookproject.Model.AuthorModel;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorDao authorDao;

    @PostMapping("/create")
    public String create(@RequestBody AuthorModel authorModel) {
        try {
            Author author = new Author(authorModel.getFirstName(), authorModel.getLastName(), authorModel.getCountry(),
                    authorModel.getBook());
            authorDao.create(author);

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

    @GetMapping(value = "/getId/{id}")
    public Author getById(@PathVariable Long id) {
        return authorDao.getById(id);
    }
  //  @GetMapping(value = "getBook/")
   // public Author getByBook

}
