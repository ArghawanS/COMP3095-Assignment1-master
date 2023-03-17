/*
 * Project: Recipe App
 * Assignment: COMP3095 Assignment2
 * Author(s): Arghawan Ghulam Siddiq,  Joyce Ashley Borla
 * Student Number: 101334946, 101190436,
 */
package gbc.comp3095.assignment2.controllers;

import gbc.comp3095.assignment2.models.User;
import gbc.comp3095.assignment2.services.UserService;
import gbc.comp3095.assignment2.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("user", new User());
        return "register/register";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute("user") User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register/register";
        }
        userService.save(user);
        return "login/login";
    }
}
