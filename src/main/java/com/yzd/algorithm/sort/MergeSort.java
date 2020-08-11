package com.yzd.algorithm.sort;

/***
 *
 * 归并排序算法步骤
 *  1. 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
 *  2. 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
 *  3. 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
 *  4. 重复步骤 3 直到某一指针达到序列尾；
 *  5. 将另一序列剩下的所有元素直接复制到合并序列尾。
 *
 *
 * @author : yanzhidong
 * @date : 2020/4/25 
 * @version : V1.0
 *
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] arr = ArrayUtil.generate(10);
        ArrayUtil.print(arr);
        int[] tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tmp);
        ArrayUtil.print(arr);
    }

    public static void mergeSort(int[] arr, int low, int high, int[] tmp) {
        if (low < high) {
            int mid = (low + high) / 2;
            //对左边序列进行归并排序
            mergeSort(arr, low, mid, tmp);
            //对右边序列进行归并排序
            mergeSort(arr, mid + 1, high, tmp);
            //合并两个有序序列
            merge(arr, low, mid, high, tmp);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high, int[] tmp) {
        int i = 0;
        //左边序列和右边序列起始索引
        int j = low, k = mid + 1;
        while (j <= mid && k <= high) {
            if (arr[j] < arr[k]) {
                tmp[i++] = arr[j++];
            } else {
                tmp[i++] = arr[k++];
            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while (j <= mid) {
            tmp[i++] = arr[j++];
        }
        while (k <= high) {
            tmp[i++] = arr[k++];
        }
        for (int t = 0; t < i; t++) {
            arr[low + t] = tmp[t];
        }
    }


}
