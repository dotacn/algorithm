package com.wxboot.algorithm.leetcode;

/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {        
        ListNode sumNode = new ListNode(0);  
        ListNode sumNext = sumNode;
        ListNode prev = null;
        while (l1 != null || l2 != null) {           
            int sum = sumNext.val;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sumNext.val = sum % 10;
            sumNext.next = new ListNode(sum / 10);
            prev = sumNext;
            sumNext = sumNext.next;   
        }
        if (sumNext.val == 0) {
            prev.next = null;
            sumNext = null;
        }

        return sumNode;
    }
   
    /**
     * l1 l2 按自然数顺序排列相加，需先将l1 l2 反转，结果反转
     * 输入：(3 -> 4 -> 2) + (4 -> 6 -> 5)
     * 输出：8 -> 0 -> 7
     * 原因：342 + 465 = 807
     * @param l1
     * @param l2
     * @return
     */
    /* 
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = converseList(l1);
        l2 = converseList(l2);
        System.out.println(l1.val);
        ...
    
    }

    public ListNode converseList(ListNode head) {
        if (head == null) return head;
        ListNode prev = null;
        ListNode next = null;
        while(head.next != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return head;
    }
    */
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
