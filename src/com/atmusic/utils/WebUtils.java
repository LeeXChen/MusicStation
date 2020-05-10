package com.atmusic.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author LIXICHEN
 * @create 2020-04-24 2:18
 */
public class WebUtils {

    /**
     * 把 map 中的值注入到对应的Javabean属性中
     *
     * @param value
     * @param bean
     */
    public static <T> T copyParamToBean(Map value, T bean) {

        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换为int类型的数据
     * @param stringInt 字符串
     * @param defaultValue 默认值
     * @return 如果转换失败，则返回默认值
     */
    public static int parseInt(String stringInt,int defaultValue){

        try{
            if(stringInt!=null){

                return Integer.parseInt(stringInt);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return defaultValue;
    }


}
