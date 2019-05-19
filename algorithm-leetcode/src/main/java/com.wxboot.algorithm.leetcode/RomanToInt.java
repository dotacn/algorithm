package com.wxboot.algorithm.leetcode;

import org.junit.Test;

/**
 * Copyright ©2017-2018, wxboot.com. All Rights Reserved.
 *
 * @author 娱乐不在线 wxboot.com
 * @version 1.0.0
 * @Description:
 * @date Created in 2019/5/19 16:59
 */
public class RomanToInt {

    @Test
    public void testOne() {
        int num = romanToInt("D");
        System.out.println("num : " + num);

    }

    public int romanToInt(String s) {
        char[] x = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};

        int num = convert(s);

        return num;
    }

    public int convert(String s) {
        int[] romanArr = new int[127];
        romanArr['M'] = 1000;
        romanArr['D'] = 500;
        romanArr['C'] = 100;
        romanArr['L'] = 50;
        romanArr['X'] = 10;
        romanArr['V'] = 5;
        romanArr['I'] = 1;

        char[] arr = s.toCharArray();
        int prev = romanArr[arr[0]];

        if (arr.length == 1) {
            return prev;
        }

        int num = 0;
        for (int i = 1; i < arr.length; i++) {
            int cur = romanArr[arr[i]];

            if (prev < cur) {
                num += cur - prev;
                if (i < arr.length - 1) {
                    prev = romanArr[arr[++i]];
                } else {
                    prev = 0;
                }

            } else {
                num += prev;
                prev = cur;
            }

            if (i == arr.length - 1) {
                num += prev;
            }
            System.out.println(arr[i] + ":" + prev + ":" + cur);
        }

        return num;
    }

}
