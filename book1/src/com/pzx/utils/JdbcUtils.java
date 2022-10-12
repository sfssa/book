package com.pzx.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author panzhixin
 * @date 2022/9/29
 * @description
 */

public class JdbcUtils {

    private static ThreadLocal<Connection>conns=new ThreadLocal<Connection>();
    private static DruidDataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            // 读取 jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从流中加载数据
            properties.load(inputStream);
            // 创建 数据库连接 池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取数据库连接池中的连接
     * @return 如果返回null,说明获取连接失败<br/>有值就是获取连接成功
     */
    public static Connection getConnection(){
        Connection connection = conns.get();
        if(connection==null){
            try {
                connection= dataSource.getConnection();
                conns.set(connection);
                connection.setAutoCommit(false);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 关闭连接，放回数据库连接池
     * @param
     */
    public static void commitAndClose(){
        Connection connection=conns.get();
        if(connection!=null){
            try {
                connection.commit();//提交事务
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    connection.close();//关闭连接
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        conns.remove();
    }
    public static void rollbackAndClose(){
        Connection connection=conns.get();
        if(connection!=null){
            try {
                connection.rollback();//提交事务
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    connection.close();//关闭连接
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        conns.remove();
    }
}