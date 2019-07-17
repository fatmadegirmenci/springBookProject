package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbookproject.springbookproject.Domain.Cart;
import springbookproject.springbookproject.Domain.User;
import springbookproject.springbookproject.Model.UserModel;
import springbookproject.springbookproject.Service.CartServiceImpl;
import springbookproject.springbookproject.Service.UserServiceImpl;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/user")
@Transactional
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    CartServiceImpl cartService;

    @PostMapping("/create")
    public String create(@RequestBody UserModel userModel) {
        try {

            User user = new User(userModel.getFirstName(), userModel.getLastName(),
                    userModel.getRegisterDate(), userModel.getAddress(), userModel.getCart());

            Cart cart = new Cart(50, user);
        //    cartService.create(cart);

            user.setCart(cart);
            userService.create(user, cart);

            return "user ekleme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "user ekleme basarisiz";
    }

    @PostMapping("/delete")
    public String delete(@RequestBody UserModel userModel) {
        try {
            userService.delete(userService.getById(userModel.getId()), userService.getById(userModel.getId()).getCart().getBook());
            return "user silme basarili";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user silme basarisiz";
    }

    @GetMapping(value = "/getId/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);

    }

}

