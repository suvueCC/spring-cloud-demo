package com.example.hystrixservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserHystrixController {

    @Autowired
    UserService userService;

    @GetMapping("/testFallback/{id}")
    public Result testFallback(@PathVariable Long id) {
        return userService.testFallback(id);
    }
}
