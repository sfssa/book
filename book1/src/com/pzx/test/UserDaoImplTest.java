package com.pzx.test;

import com.pzx.dao.UserDao;
import com.pzx.dao.impl.UserDaoImpl;
import com.pzx.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    UserDao userDao=new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        if(userDao.queryUserByUsername("fafa")==null){
            System.out.println("用户名可用");
        }else{
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("pzx","panzhixin")==null){
            System.out.println("用户名或密码错误");
        }else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"panzhixin","20011214","pzx_panzhixin@sina.com")));

    }
}