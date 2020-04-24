package com.yzd.algorithm.sort;

/***
 * 冒泡排序
 * @author : yanzhidong
 * @date : 2020/4/23 
 * @version : V1.0
 *
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] array = ArrayUtil.generate(10);
        ArrayUtil.print(array);
        sort(array);
        ArrayUtil.print(array);
    }

    /**
     * 从小到大排序
     *
     * @param array
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = i + 1; j < array.length; j++) {
                int temp = array[i];
                if (array[i] > array[j]) {
                    array[i] = array[j];
                    array[j] = temp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            if (!flag) break;
        }

    }


}
