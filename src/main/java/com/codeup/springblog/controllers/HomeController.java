package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
  @GetMapping("/")
//  Instead of returning a string like we were before, with the help of springboot thymeleaf we can call the html name, and it will link the html file.
  public String home(){
    return "home";
  }


}
