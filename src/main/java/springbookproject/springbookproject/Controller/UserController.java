package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Beans.User;
import springbookproject.springbookproject.Dao.ChartDao;
import springbookproject.springbookproject.Dao.UserDao;
import springbookproject.springbookproject.Model.UserModel;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    ChartDao chartDao;

    @PostMapping("/create")
    public String create(@RequestBody UserModel userModel) {
        try {
            User user = new User(userModel.getFirstName(), userModel.getLastName(),
                    userModel.getRegisterDate(), userModel.getAddress(), userModel.getChart());

            userDao.create(user);

            return "user ekleme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "user ekleme basarisiz";
    }

    @PostMapping("/delete")
    public String delete(@RequestBody UserModel userModel) {
        try {
            userDao.delete(userDao.getById(userModel.getId()));
            return "user silme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user silme basarisiz";
    }

    @GetMapping(value = "/getId/{id}")
    public User getByUser(@PathVariable Long id) {
        return userDao.getById(id);
    }

}
