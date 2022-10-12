package com.pzx.service;

import com.pzx.pojo.User;

/**
 * @author: gfk
 * @create: 2022/9/29
 * @Description:
 * @FileName: UserServicre
 * @History:
 */
public interface UserService {

    /*public void registerUser(User user);
    public User login(User user);
    public boolean existsUsername(String username);*/

    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return 如果返回null，说明登录失败，返回有值，是登录成功
     */
    public User login(User user);

    /**
     * 检查 用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public boolean existsUsername(String username);
}
