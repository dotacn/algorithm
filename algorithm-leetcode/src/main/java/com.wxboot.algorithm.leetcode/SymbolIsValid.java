package com.wxboot.algorithm.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * Copyright ©2017-2018, wxboot.com. All Rights Reserved.
 *
 * @author 娱乐不在线 wxboot.com
 * @version 1.0.0
 * @Description:
 * @date Created in 2019/5/20 0:47
 */
public class SymbolIsValid {

    @Test
    public void testOne() {
        System.out.println(isValid("()"));
    }

    public boolean isValid(String s) {
        char[] arr = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        boolean isValid = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '{') {
                stack.push('}');
            }
            if (arr[i] == '(') {
                stack.push(')');
            }
            if (arr[i] == '[') {
                stack.push(']');
            }

            if (arr[i] == '}' || arr[i] == ')' || arr[i] == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                isValid = stack.pop() == arr[i];
                if (isValid) {
                    continue;
                }
                return false;
            }
        }
        return isValid;
    }

}

