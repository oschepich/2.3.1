package com.oschepich.spring_mvc_hibernate.controler;

import com.oschepich.spring_mvc_hibernate.model.User;
import com.oschepich.spring_mvc_hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Выводим список всех пользователей на WEB страницу

    @GetMapping(value = "/")
    public String showAllUser(Model model) {
        model.addAttribute("allUser", userService.getAllUser());
        return "showUsers";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "new";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    //    Сохранение пользователя
    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
    @GetMapping(value = "/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.show(id));
        return ("update");
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id){
        userService.saveUser(user);
        return "redirect:/";
    }


}



