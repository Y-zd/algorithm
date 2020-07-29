算法数据结构学习
==
(对应LeetCode编号)
---

[链表](/src/main/java/com/yzd/algorithm/linked)

 * [单链表反转(206)](/src/main/java/com/yzd/algorithm/linked/DeleteNodeN.java)
 
 * [链表中环的检测(141)](/src/main/java/com/yzd/algorithm/linked/DetectionOfRing.java) 
   
 * [两个有序的链表合并(21)](/src/main/java/com/yzd/algorithm/linked/MergeTwoOrderedLinked.java)  
    
 * [删除链表倒数第n个结点(19)](/src/main/java/com/yzd/algorithm/linked/DeleteNodeN.java) 
   
 * [求链表的中间结点(876)](/src/main/java/com/yzd/algorithm/linked/MiddleNode.java)  


[栈](/src/main/java/com/yzd/algorithm/stack)

 * [有效的括号(20)](/src/main/java/com/yzd/algorithm/stack/ValidParentheses.java)

 * [最小栈(155)](/src/main/java/com/yzd/algorithm/stack/MinStack.java)

 * [用栈实现队列(232)](/src/main/java/com/yzd/algorithm/stack/ImplementQueueUsingStacks.java) 
 
 * [用队列实现栈](/src/main/java/com/yzd/algorithm/stack/ImplementStacksUsingQueue.java)
 
 * [比较含退格的字符串(844)](/src/main/java/com/yzd/algorithm/stack/BackspaceStringCompare.java) 

 * [基本计算器(224)](/src/main/java/com/yzd/algorithm/stack/BasicCalculator.java) 

 * [棒球比赛(682)](/src/main/java/com/yzd/algorithm/stack/BaseballGame.java) 

 * [下一个更大元素I(496)](/src/main/java/com/yzd/algorithm/stack/NextGreaterElementI.java) 

[排序](/src/main/java/com/yzd/algorithm/sort)

 * [冒泡排序](/src/main/java/com/yzd/algorithm/sort/BubbleSort.java)

 * [插入排序](/src/main/java/com/yzd/algorithm/sort/InsertionSort.java)
   - 冒泡排序和插入排序的时间复杂度都是O(n2)，都是原地排序算法，都是稳定的排序算法。
   - 冒泡排序插和入排序不管怎么优化，元素交换的次数是一个固定值，是原始数据的逆序度。
   - 为什么插入排序要比冒泡排序更受欢迎呢？
     - 代码实现上来看，冒泡排序的数据交换要比插入排序的数据移动要复杂，冒泡排序需要 3 个赋值操作，而插入排序只需要 1 个
   ```java
        //冒泡排序中数据的交换操作：
        if (a[j] > a[j+1]) { // 交换
           int tmp = a[j];
           a[j] = a[j+1];
           a[j+1] = tmp;
           flag = true;
        }   
        //插入排序中数据的移动操作：
        if (a[j] > value) {
          a[j+1] = a[j];  // 数据移动
        } else {
          break;
        }
   ```
 
 * [归并排序](/src/main/java/com/yzd/algorithm/sort/MergeSort.java)
   - 并归排序是稳定的排序算法不是原地排序，时间复杂度是O(nlogn) 空间复杂度是 O(n)

 * [快速排序](/src/main/java/com/yzd/algorithm/sort/QuickSort.java)
   - 快排是一种原地、不稳定的排序算法，间复杂度也是 O(nlogn)


