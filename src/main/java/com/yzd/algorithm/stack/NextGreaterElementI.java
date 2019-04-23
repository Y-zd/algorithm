package com.yzd.algorithm.stack;

import java.util.HashMap;
import java.util.Stack;

/***
 * @ClassName: NextGreaterElementI
 * @Auther: yanzhidong
 * @Date: 2019/4/12 15:50
 * @version : V1.0
 * @Description:
 *       给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *       nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 *
 *例1：
 *      输入： nums1 = [4,1,2]，nums2 = [1,3,4,2]。
 *      输出： [ -  1,3，-1]
 *  说明：
 *     对于第一个数组中的数字4，在第二个数组中找不到下一个更大的数字，因此输出-1。
 *     对于第一个数组中的数字1，第二个数组中的下一个更大数字是3。
 *     对于第一个数组中的数字2，第二个数组中没有下一个更大的数字，因此输出-1。
 *例2：
 *     输入： nums1 = [2,4]，nums2 = [1,2,3,4]。
 *     输出： [3，-1]
 *  说明：
 *     对于第一个数组中的数字2，第二个数组中的下一个更大数字是3。
 *     对于第一个数组中的数字4，第二个数组中没有下一个更大的数字，因此输出-1。
 *
 */
public class NextGreaterElementI {


    /**
     * 方法1：两层for循环
     * 时间复杂度：O(n^2)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[k] > nums1[i]) {
                            result[i] = nums2[k];
                            break;
                        }
                    }

                }
            }

        }
        return result;
    }


    /**
     * 方法2：两层for循环，在方法1的基础上用哈希表先来建立每个数字和其坐标位置之间的映射
     * 时间复杂度：O(n^2)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = -1;

            Integer integer = map.get(nums1[i]);
            if (integer != null) {
                for (int k = integer + 1; k < nums2.length; k++) {
                    if (nums2[k] > nums1[i]) {
                        result[i] = nums2[k];
                        break;
                    }

                }
            }

        }
        return result;
    }


    /**
     * 方法3： 如果一个序列是递减的序列只有最后一个元素是增加的：[5,4,3,2,1,6]，
     * 那么对于序列：[5,4,3,2,1]的右边的第一个大的数都是6。那么我们具体怎么做呢？
     * 只需要一个stack即可，如果即将要放入的元素x比栈顶的元素大，
     * 那么栈顶元素的右边第一个大元素就是x，然后把栈顶元素出栈，继续比较栈顶元素和x，如果x小于等于栈顶元素，那么把x放入栈中。
     * 由于待查找的元素findNums和nums是两个数组，所以需要一个hashmap来对应findNums中的元素和其下标的对应关系（map<value，index>），
     * 那么每次我们只要比较map里的元素的key作为栈顶元素就行了。
     * <p>
     * 时间复杂度：O(N)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        return nums1;

//        vector<int> res (findNums.size(), -1);
//        unordered_map<int, int> map;
//        for (int i = 0; i < findNums.size(); i++) {
//            map[findNums[i]] = i;
//        }
//        stack<int> s;
//        for (int i = 0; i < nums.size(); i++) {
//            if (i == 0 || (i > 0 && nums[i] <= nums[i - 1])) {
//                s.push(nums[i]);
//            } else {
//
//                while (!s.empty() && map.find(s.top()) != map.end() && nums[i] > s.top()) {
//                    res[map[s.top()]] = nums[i];
//                    s.pop();
//                }
//                s.push(nums[i]);
//            }
//        }
//        return res;

    }


    public static void main(String[] args) {

        //nums1 = [4,1,2]，nums2 = [1,3,4,2]
        // 输出： [ -  1,3，-1]
        int[] ints = nextGreaterElement1(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ",");
        }

        System.out.println();
        int[] result = nextGreaterElement2(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }


        // 输入： nums1 = [2,4]，nums2 = [1,2,3,4]。
        // 输出： [3，-1]
        System.out.println();
        int[] result2 = nextGreaterElement2(new int[]{2, 4}, new int[]{1, 2, 3, 4});
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + ",");
        }

    }

}
