package com.pzx.utils;

import com.pzx.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author panzhixin
 * @date 2022/10/3
 * @description
 */

public class WebUtils {
    public static <T>T copyParamToBean(Map value, T bean){
        try {
            System.out.println("注入之前：" + bean);
            /**
             * 把所有请求的参数都注入到user对象中
             */
            BeanUtils.populate(bean, value);
            System.out.println("注入之后：" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        }catch (Exception e){
            //e.printStackTrace();
        }
        return defaultValue;
    }
}