package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller tells spring that is going to be SIMLIAR to a SERVLET, like in adlister...
@Controller
public class HelloContoller {
//Mapping is like the url thing from servlets?
//  a get mapping requires a response body.
//  This is like our doGet for our controller.
  @GetMapping("/hello")
  @ResponseBody
  public String hello(){
    return "<h1> Hello from spring</h1>";
  }
//  We can see the message above by visiting http://localhost:8080/hello
//  variable name needs to match the (thing) so name and name need to be the same!
  @GetMapping("hello/{name}")
  @ResponseBody
  public String sayHello(@PathVariable String name) {
    return "Hello " + name + "!";
  }

  @GetMapping("/number/{num}")
  @ResponseBody
  public int displayNumber(@PathVariable int num){
    return num;
  }
//  Below says explicitly we are using the GET Method, with this maping, rather than POST.
  @RequestMapping(path ="/hello/in/{color}", method = RequestMethod.GET)
  @ResponseBody
  public String helloInColor(@PathVariable String color){
    return "<h1 style=\"color:" + color + "\"> Hello in " +color + "!</h1>";
  }
}

