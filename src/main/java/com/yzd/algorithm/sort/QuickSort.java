package com.yzd.algorithm.sort;

import java.util.Arrays;

/***
 *  快速排序
 该方法的基本思想是
 1．先从数列中取出一个数作为基准数。
 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
 3．再对左右区间重复第二步，直到各区间只有一个数。
 * @author : yanzhidong
 * @date : 2020/1/16 
 * @version : V1.0
 *
 */
public class QuickSort {


    public static void test() {

    }

    public static void main(String[] args) {
        int[] arr = {38, 46, 15, 6, 90, 99, 11, 5, 3, 100};
        quick_sort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void quick_sort(int arr[], int left, int right) {
        if (left < right) {
            int i = left, j = right, x = arr[left];
            while (i < j) {
                while (i < j && arr[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j)
                    arr[i++] = arr[j];

                while (i < j && arr[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j)
                    arr[j--] = arr[i];
            }
            arr[i] = x;
            quick_sort(arr, left, i - 1); // 递归调用
            quick_sort(arr, i + 1, right);
        }
    }

}
