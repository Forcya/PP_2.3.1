package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.entity.User;
import web.service.UserService;



@Controller
@RequestMapping("/users")
public class MyController {

    @Autowired
    private UserService userService;  //Чтобы не создавать объект используем Di

    @GetMapping
    public String showAllUsers(Model model) {

        model.addAttribute("allUsr", userService.getAllUsers());

        return "allUsers";
    }

    @GetMapping("/new")
    public String addNewUser(@ModelAttribute("user") User user) {
        return "newUser";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/update")
    public String updateUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "updateUser";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }




}
