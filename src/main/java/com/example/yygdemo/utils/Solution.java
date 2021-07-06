package com.example.yygdemo.utils;

import com.example.yygdemo.store.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 两数之和返回下标
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * 两个数相加，并以相同形式返回一个表示和的链表。两个链表之和
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 链表是逆序存储
         * 思路：
         * 1. 判断两个链表的长度是否一致，短的填补 0.
         * 2. 两位链表的同一位置的数据相加的同时加上进位制 .
         * 3. 取余（%） 左>右 取左 . 右>左 取余数 .
         * 4. 除(/) 取整
         */
        ListNode head = null,tail = null;
        int carry = 0;
        while (l1 !=null || l2 !=null){
            int n1 = l1 !=null ? l1.val :0;
            int n2 = l2 !=null ? l2.val :0;
            int sum = n1+n2+carry;
            if(head == null){ //链表开头
               head = tail =  new ListNode(sum%10);
            }else{
                tail.next = new ListNode(sum%10);
                tail = tail .next;
            }
            carry = sum/10;//是否需要进位
            if(l1 !=null){
                l1 = l1.next;
            }
            if(l2 !=null){
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    } 

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 5, 5};
        int[] ints = twoSum(nums, 5);
        System.out.println(ints);
    }
}
