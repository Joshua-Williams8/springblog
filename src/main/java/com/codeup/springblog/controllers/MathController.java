package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

  @GetMapping("add/{x}/and/{y}")
  @ResponseBody
  public String add(@PathVariable int x,@PathVariable int y){
    int sum =  x + y;
    String result = String.valueOf(sum);
    return result;
  }

  @GetMapping("subtract/{x}/from/{y}")
  @ResponseBody
  public String subtract(@PathVariable int x,@PathVariable int y){
    int difference = y - x;
    String result = String.valueOf(difference);
    return result;
  }

  @GetMapping("multiply/{x}/and/{y}")
  @ResponseBody
  public String multiply(@PathVariable int x,@PathVariable int y){
    int product = x * y;
    String result = String.valueOf(product);
    return result;
  }

  @GetMapping("divide/{x}/by/{y}")
  @ResponseBody
  public String divide(@PathVariable int x,@PathVariable int y){
    int quotient =  x / y;
    String result = String.valueOf(quotient);
    return result;
  }




}
