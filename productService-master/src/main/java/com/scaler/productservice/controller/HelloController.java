package com.scaler.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This class will be serving http methods at /hello
// This class will be serving HTTP APIs
// localhost:8080/hello
@RequestMapping("/hello")
@RestController
        public class HelloController {
    // This method will be serving http methods at /say/name/number
       @GetMapping("/say/{name}/{times}")
       public String sayHello(@PathVariable("name") String name, @PathVariable("times") int times){
              String ans = "";
           for(int i=0; i< times;i++){
               ans += "Hello "+name;
               ans += "<br>";
           }
           return ans;
       }
}
