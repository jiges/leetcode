package com.ccr.leetcode.p4_median_of_two_sorted_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * @author ccr12312@163.com at 2019-1-2
 */


class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
            两个有序数组合并后的中位数,和归并算法类似
         */
        if (nums1 == null) {
            return findMedianSortedArrays(nums2);
        } else if (nums2 == null) {
            return findMedianSortedArrays(nums1);
        } else {
            int length = (nums1.length + nums2.length) / 2 + 1;
            int i = 0, j = 0;
            int leftValue = 0, rightValue = 0;
            for (int k = 0; k < length; k ++) {
                if(i >= nums1.length) {
                    if(k == length - 2) {
                        leftValue = nums2[j];
                    }
                    if(k == length - 1) {
                        rightValue = nums2[j];
                    }
                    j ++;
                } else if(j >= nums2.length){
                    if(k == length - 2) {
                        leftValue = nums1[i];
                    }
                    if(k == length - 1) {
                        rightValue = nums1[i];
                    }
                    i ++;
                } else {
                    if(nums1[i] < nums2[j]) {
                        if(k == length - 2) {
                            leftValue = nums1[i];
                        }
                        if(k == length - 1) {
                            rightValue = nums1[i];
                        }
                        i ++;
                    } else {
                        if(k == length - 2) {
                            leftValue = nums2[j];
                        }
                        if(k == length - 1) {
                            rightValue = nums2[j];
                        }
                        j ++;
                    }
                }
            }

            if((nums1.length + nums2.length) % 2 == 0) {
                return (leftValue + rightValue) / 2.0;
            } else {
                return rightValue;
            }

        }

    }

    private double findMedianSortedArrays(int nums[]) {
        if (nums != null) {
            int length = nums.length;
            return (nums[(length - 1) / 2] + nums[length / 2]) / 2.0;
        } else
            return 0.0;
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
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String doubleToString(double input) {
        return new DecimalFormat("0.00000").format(input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums1 = stringToIntegerArray(line);
            line = in.readLine();
            int[] nums2 = stringToIntegerArray(line);

            double ret = new Solution().findMedianSortedArrays(nums1, nums2);

            String out = doubleToString(ret);

            System.out.print(out);
        }
    }
}