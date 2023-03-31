package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String mainPage() {
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("listUser", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user, @PathVariable(value = "id") long id) {
        userService.editUser(user, id);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String removeUserById(@PathVariable(value = "id") long id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }
}