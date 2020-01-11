package com.shrimp.util;

/**
 * @description: 数组相关的工具类
 * @author: shrimp
 * @date: Created in 2020-01-11 17:39
 * @version: 1.0
 */
public class ArrayUtil {

    /**
     * @Description: 获取一个double类型的数字的小数位有多长
     * @Author Shrimp
     * @date: 2020-01-11 17:40
     * @Param: [dd]
     * @Return: int
     **/
    public static int doueleBitCount(double dd) {

        String temp = String.valueOf(dd);
        int i = temp.indexOf(".");
        if (i > -1) {
            return temp.length() - i - 1;
        }
        return 0;

    }

    public static Integer[] doubleBitCount(double[] arr) {
        Integer[] len = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            len[i] = doueleBitCount(arr[i]);
        }
        return len;
    }
}
