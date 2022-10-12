package com.pzx.test;

import com.pzx.pojo.User;
import com.pzx.service.UserService;
import com.pzx.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService=new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registUser(new User(null,"zhangsan","123456","123456@qq.com"));
        userService.registUser(new User(null,"lisi","abcde","abcde@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"pzx","psanzhixin","1664549131@qq.com")));

    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("pzx")){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名可用");
        }
    }
}