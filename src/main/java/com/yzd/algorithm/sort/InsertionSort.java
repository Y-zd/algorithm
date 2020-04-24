package com.yzd.algorithm.sort;

/***
 * 插入排序
 *
 * 首先，我们将数组中的数据分为两个区间，已排序区间和未排序区间。
 * 初始已排序区间只有一个元素，就是数组的第一个元素。
 * 插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，
 * 并保证已排序区间数据一直有序。重复这个过程，直到未排序区间中元素为空，算法结束。
 * @author : yanzhidong
 * @date : 2020/4/23 
 * @version : V1.0
 *
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = ArrayUtil.generate(10);
        ArrayUtil.print(array);
        sort(array);
        ArrayUtil.print(array);
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > value) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }


    }

}
