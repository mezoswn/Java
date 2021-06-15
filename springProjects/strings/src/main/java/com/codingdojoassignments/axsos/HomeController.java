package com.codingdojoassignments.axsos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//..
@RestController
@RequestMapping("/")
public class HomeController {
   @RequestMapping("")
   public String hello() {
           return "Hello client! How are you doing?";
   }
   @RequestMapping("/random")
   public String world() {
           return "Spring Boot is great! So easy to just respond with strings";
   }
}