package com.codingdojoassignments.axsos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 2. Importing dependencies
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
// 1. Annotation
@RestController
public class StringsApplication {
        public static void main(String[] args) {
                SpringApplication.run(StringsApplication.class, args);
        }
}
