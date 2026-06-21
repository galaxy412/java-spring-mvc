package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.service.UserService;

// @RestController
// public class UserController {
//     // DI : dependency injection
//     private UserService userService;

//     public UserController(UserService userService) {
//         this.userService = userService;
//     }

//     @GetMapping("/")
//     public String getHomePage() {
//         return userService.handleHello();
//     }

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = userService.handleHello();
        model.addAttribute("eric", test); // Thêm dữ liệu vào model để truyền đến view
        model.addAttribute("hoidanit", "from controller with model"); // Thêm một thuộc tính khác vào model
        return "hello"; // Trả về tên của view (mapped to /WEB-INF/view/hello.jsp)
    }
}
