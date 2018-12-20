package com.ccr.leetcode.p27_remove_element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode-cn.com/problems/remove-element/
 * @author ccr12312@163.com at 2018-12-19
 */
class Solution {

    public int removeElement(int[] nums, int val) {
        /*
         * 设置两个指针指向数组的头部和尾部，从头部开始扫描，
         * 遇到val就将尾部不是val的数字复制到当前位置
         * 时间复杂度O(n)
         */
        int head = 0,tail = nums.length - 1;
        loop:
        while (head <= tail) {
            if (nums[head] == val) {
                while (nums[tail] == val) {
                    if (-- tail < head)
                        break loop;
                }
                //复制到当前位置 然后head自增，tail自减
                nums[head ++] = nums[tail--];
            } else {
                head++;
            }
        }
        return tail + 1;
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int val = Integer.parseInt(line);

            int ret = new Solution().removeElement(nums, val);
            System.out.println(ret);
            String out = integerArrayToString(nums, ret);

            System.out.print(out);
        }
    }
}