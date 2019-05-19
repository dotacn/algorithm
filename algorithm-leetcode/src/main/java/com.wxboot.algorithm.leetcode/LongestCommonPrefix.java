package com.wxboot.algorithm.leetcode;

import org.junit.Test;

/**
 * Copyright ©2017-2018, wxboot.com. All Rights Reserved.
 *
 * @author 娱乐不在线 wxboot.com
 * @version 1.0.0
 * @Description:
 * @date Created in 2019/5/19 17:36
 */
public class LongestCommonPrefix {


    @Test
    public void testOne() {
        String[] arr = {"abcddddb", "abcdeggg", "abadeggg"};

        String prefix = getPrefixStartCmp(arr);
        System.out.println("prefix : " + prefix);
    }

    /**
     * 貌似正向比对比逆向比对要快一些
     *
     * @param arr
     * @return
     */
    public String getPrefixStartCmp(String[] arr) {
        if (arr.length == 0) {
            return "";
        }
        if (arr.length == 1) {
            return arr[0];
        }

        int last = arr[0].length();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].length() == 0 || arr[i + 1].length() == 0) {
                return "";
            }

            last = getMin(last, arr[i + 1].length());
            for (int j = 0; j < last; j++) {
                if (arr[i].charAt(j) != arr[i + 1].charAt(j)) {
                    last = j;
                }
            }
        }

        char[] prefixArr = new char[last];
        for (int i = 0; i < last; i++) {
            prefixArr[i] = arr[0].charAt(i);
        }

        return String.valueOf(prefixArr);
    }

    public String getPrefixEndCmp(String[] arr) {
        if (arr.length == 0) {
            return "";
        }
        if (arr.length == 1) {
            return arr[0];
        }

        int last = arr[0].length();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].length() == 0 || arr[i + 1].length() == 0) {
                return "";
            }

            last = getMin(last, arr[i + 1].length());

            for (int j = last - 1; j >= 0; j--) {
                if (arr[i].charAt(j) != arr[i + 1].charAt(j)) {
                    last = j;
                }
            }
        }

        char[] prefixArr = new char[last];
        for (int i = 0; i < last; i++) {
            prefixArr[i] = arr[0].charAt(i);
        }

        return String.valueOf(prefixArr);
    }

    public int getMin(int x, int y) {
        return x > y ? y : x;
    }
}