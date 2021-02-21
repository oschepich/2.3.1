package com.oschepich.spring_mvc_hibernate.controler;

import com.oschepich.spring_mvc_hibernate.model.User;
import com.oschepich.spring_mvc_hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Выводим список всех пользователей на WEB страницу
    @GetMapping()
    public String showAllUser(Model model) {
        model.addAttribute("allUser", userService.getAllUser());
        return "showUsers";
    }

    //
//    @RequestMapping("/addNewUser")
//    public String addNewUser(Model model){
//        User user=new User();
//        model.addAttribute("newUser",user);
//    return "user-add";
//    }
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    //    Сохранение пользователя
    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        if (user.getId()==0) {
            userService.saveUser(user);
        }
        else userService.updateUser(user);
        return "redirect:/";
    }


}


//    // Выводим список машин на WEB страницу взависимости от запроса
//    @GetMapping("/")
//    public String showAllUser(@RequestParam(value = "count", required = false) Integer count, Model model) {
//        if (count == null) {
//            model.addAttribute("list", carService.getCarServiceList());
//        } else if (count < 5 && count > 0) {
//            model.addAttribute("list", carService.showCars(count, carService.getCarServiceList()));
//        } else model.addAttribute("list", carService.getCarServiceList());
//
//        return "indexCar";



