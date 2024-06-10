package web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import web.service.UserService;

@Controller
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users-list";
    }
    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-create";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/users/delete")
    public String deleteUserById(@RequestParam("id") int id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(User user) {
      userService.saveUser(user);
        return "redirect:/users";
    }
}