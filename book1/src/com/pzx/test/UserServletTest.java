package com.pzx.test;

import com.pzx.service.UserService;

import java.lang.reflect.Member;
import java.lang.reflect.Method;

/**
 * @author panzhixin
 * @date 2022/10/3
 * @description
 */

public class UserServletTest {
    public void login(){
        System.out.println("这是login方法调用");
    }
    public void regist(){
        System.out.println("这是regist方法调用");
    }
    public void addUser(){
        System.out.println("这是addUser方法调用");
    }

    public static void main(String[] args) {
        String action="login";
        try {
            Method method=UserServletTest.class.getMethod(action);
            System.out.println(method);
            method.invoke(new UserServletTest());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}