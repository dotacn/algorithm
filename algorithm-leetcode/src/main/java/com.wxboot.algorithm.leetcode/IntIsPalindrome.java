package com.wxboot.algorithm.leetcode;

public class IntIsPalindrome {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        long y = reverseTwo(x);
        return x == y;
    }

    public long reverseTwo(int x) {
        int quotient = x;
        // 54321 -> 5432 1 -> 543 2 -> 54 3 -> 5 4-> 0 5 
        long y = 0;
        while (quotient > 0) {
            y = quotient%10 + y*10;
            quotient = quotient/10;
        }
        return y > Integer.MAX_VALUE ? 0 : y;
    }

    public long reverseOne(int x) {        
        String s = String.valueOf(x);
        char[] arr = s.toCharArray();
        // 12 1 123 1 1234 2 
        int mid = (arr.length / 2);
        for (int i = 0; i < mid; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        long y = Long.valueOf(String.valueOf(arr));
        return y > Integer.MAX_VALUE ? 0 : y;
    }

}