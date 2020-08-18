package com.yzd.algorithm.find;

/***
 *  二分查找
 *  时间复杂度  O(logn)
 * @author : yanzhidong
 * @date : 2020/8/18 
 * @version : V1.0
 *
 */
public class Bsearch {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(bsearch(a, 3));
        System.out.println(bsearchInternally(a, 0, a.length - 1, 3));

    }

    public static int bsearch(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        int count = 1;
        while (low <= high) {
            System.out.println("第" + count++ + "次查找");
            int mid = (low + high) / 2;//可优化成(low+high)>>1
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    /**
     * @param a
     * @param value
     * @return
     */
    public static int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid + 1, high, value);
        } else {
            return bsearchInternally(a, low, mid - 1, value);
        }
    }

}
