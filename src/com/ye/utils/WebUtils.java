package com.ye.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-11 18:27
 */
public class WebUtils {


    /**
     * 把Map中的值注入到对应的JAVABean中
     * @param map
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> T copyParamToBean(Map map,T bean){

        System.out.println("注入之前："+bean.toString());

        try {
            BeanUtils.populate(bean,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("注入之后："+bean.toString());

        return bean;
    }

    /**
     * 将字符串转换成int类型的数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }

        return defaultValue;
    }




}
