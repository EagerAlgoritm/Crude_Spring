package spring_crud.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring_crud.dao.UserDao;
import spring_crud.dao.UserDaoImpl;
import spring_crud.model.User;
import spring_crud.service.UserService;


import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/")
    public String showAllUsers(Model model) {
        List<User> userList = userService.GetAllUsers();
        model.addAttribute("userList", userList);

        return "All-Users";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {

        User user = new User();
        model.addAttribute("User", user);

        return "User-Info";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("User") User user) {

        userService.saveUser(user);

        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateUser(@RequestParam("userId") int id, Model model) {

        User user = userService.getUser(id);
        model.addAttribute("User", user);

        return "User-Info";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") int id) {

        userService.deleteUser(id);

        return "redirect:/";
    }
}
