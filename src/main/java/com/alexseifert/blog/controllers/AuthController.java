package com.alexseifert.blog.controllers;

import com.alexseifert.blog.dto.UserDto;
import com.alexseifert.blog.entity.User;
import com.alexseifert.blog.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

@Controller
public class AuthController {

  private UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/register")
  public String register() {
    return "register";
  }

  @PostMapping("/register")
  public String registerSave(@Valid @ModelAttribute("user") UserDto user,
                             BindingResult result,
                             Model model) {
    User existing = userService.findByEmail(user.getEmail());

    if (existing != null) {
      result.rejectValue("email", null, "There is already an account registered with that email");
    }

    if (result.hasErrors()) {
      model.addAttribute("user", user);
      return "register";
    }

    userService.saveUser(user);

    return "redirect:/register?success";
  }

}
