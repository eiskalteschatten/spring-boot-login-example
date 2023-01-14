package com.alexseifert.blog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/admin")
public class AdminController {

  @GetMapping("/")
  public String index() {
    return "admin/index";
  }

}
