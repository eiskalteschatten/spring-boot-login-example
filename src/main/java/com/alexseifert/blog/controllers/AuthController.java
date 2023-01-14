package com.alexseifert.blog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthController {

  @GetMapping("/login")
  public String login() {
    return "login";
  }
  
}
