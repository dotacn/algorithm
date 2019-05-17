package com.wxboot.algorithm.leetcode;

import java.util.stream.IntStream;

public class LengthOfLongestSubstring {


    private int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int[] bucket = new int[128];
        // 使用原生 for 速度会更快
        IntStream.iterate(0, n -> n + 1).limit(127).forEach(n -> bucket[n] = -1);

        char[] arr = s.toCharArray();
        int left = -1;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int cur = bucket[arr[i]];
            if (cur != -1) {
                left = cur > left ? cur : left;
            }

            bucket[arr[i]] = i;
            max = getMax(max, i - left);
        }

        return max;
    }

    private int getMax(int x, int y) {
        return x > y ? x : y;
    }

}
