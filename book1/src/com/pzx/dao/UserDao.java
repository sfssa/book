package com.pzx.dao;

import com.pzx.pojo.User;

import java.util.StringTokenizer;

/**
 * @author: gfk
 * @create: 2022/9/29
 * @Description:
 * @FileName: UserDao
 * @History:
 */
public interface UserDao {
    /*public User queryUserByUsername(String name);
    public User queryUserByUsernameAndPassword(String name,String password);
    public int saveUser(User user);*/

    public User queryUserByUsername(String username);
    public User queryUserByUsernameAndPassword(String username, String password);
    public int saveUser(User user);
}
