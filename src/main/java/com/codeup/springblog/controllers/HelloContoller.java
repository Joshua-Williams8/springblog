package com.codeup.springblog.controllers;

import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@Controller tells spring that is going to be SIMLIAR to a SERVLET, like in adlister...
@Controller
public class HelloContoller {
//Mapping is like the url thing from servlets?
//  a get mapping requires a response body.
//  This is like our doGet for our controller.

  private final EmailService emailSvc;

  public HelloContoller(EmailService emailSvc){
    this.emailSvc = emailSvc;
  }

  @GetMapping("/hello")
  @ResponseBody
  public String hello(){
    return "<h1> Hello from spring</h1>";
  }
//  We can see the message above by visiting http://localhost:8080/hello
//  variable name needs to match the (thing) so name and name need to be the same!
@GetMapping("/hello/{name}")
public String sayHello(@PathVariable String name, Model model) {
  model.addAttribute("name", name);
  return "hello";
}
//Below we are pointing to our html doc to just pull it up
@GetMapping("/join")
public String getJoinForm(){
    return "join";
}
//Below we are accepting the post from the form...
@PostMapping("/join")
//Similar to request.getparameter from jsps.
public  String joinCohort(@RequestParam(name = "cohort") String cohort, Model model){

    model.addAttribute("cohort", "Welcome to " + cohort);
    emailSvc.prepareAndSend("jnwilliams8254@gmail.com", "Testing email "+ cohort, "Thanks for working properly...");
    return "join";
}

//We can use other kinds of tags for our html like the c:when otherwise etc...


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

