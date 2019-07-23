package springbookproject.springbookproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbookproject.springbookproject.Model.UserModel;
import springbookproject.springbookproject.Service.UserServiceImpl;

import javax.transaction.Transactional;

@RestController
@Transactional
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/")
    public String login(@RequestBody UserModel userModel) {
        String userName = userModel.getUserName();
        int parola = userModel.getParola();

        if(userService.checkUserName(userName) == true) {
            if(userService.checkParola(userName, parola) == true) {
                return "giris basarili";
            } else {
                return "hatali parola";
            }
        } else {
            return "boyle bir kullanici adi bulunamadi";
        }
    }
}
