package com.example.userservice;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 测试的用户控制器
 *
 * @author suvue
 * @date 2020/6/8
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @SneakyThrows
    @PostMapping("/insert")
    public Result insert(@RequestBody User user) {
        Thread.sleep(2000);
        System.out.println("成功保存用户信息：" + user);
        return new Result("操作成功", 200);
    }

    @GetMapping("/{id}")
    public Result<User> insert(@PathVariable Long id) {
        final User user = User.builder().id(id).username("米斯特赵").password("123456").build();
        System.out.println("成功获取用户信息："+user);
        return new Result<>(user);
    }
}
