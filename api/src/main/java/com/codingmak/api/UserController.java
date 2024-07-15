package com.codingmak.api;

import com.codingmak.model.User;
import com.codingmak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/admin/register")
    public String registerUser(User user) {
        userService.registerUser(user);
        return "redirect:/login";
    }

    @GetMapping("/admin/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/admin/home")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/admin/error")
    public String showErrorPage() {
        return "error";
    }
}
