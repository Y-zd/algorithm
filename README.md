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

|            | 时间复杂度 | 是否稳定排序 | 是否原地排序 |
| :--------- | ---------- | :----------- | :----------- |
| 冒泡怕排序 | O(n^2) | 是 | 是 |
| 插入排序   | O(n^2) | 是 | 是 |
| 选择排序   | O(n^2) | 否 | 是 |
| 快速排序   | O(n*logn) | 否 | 是 |
| 归并排序   | O(n*logn) | 是 | 否 |
| 计数排序   | O(n+k) k是数据范围 | 是 | 否 |
| 桶排序     | O(n) | 是 | 否 |
| 基数排序   | O(dn) d是维度 | 是 | 否 |

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

 * [计数排序](/src/main/java/com/yzd/algorithm/sort/CountingSort.java)

 * [二分查找](/src/main/java/com/yzd/algorithm/find/Bsearch.java)
   - 时间复杂度O(logn)
   
  散列表
  散列表的装载因子=填入表中的元素个数/散列表的长度
 
 [二叉树](/src/main/java/com/yzd/algorithm/tree)
 * 二叉树既可以用链式存储，也可以用数组顺序存储。
 数组顺序存储的方式比较适合完全二叉树，其他类型的二叉树用数组存储会比较浪费存储空间。
 除此之外，二叉树里非常重要的操作就是前、中、后序遍历操作，遍历的时间复杂度是 O(n)
 * 二叉树的遍历
   1. 前序遍历是指，对于树中的任意节点来说，先打印这个节点，然后再打印它的左子树，最后打印它的右子树。
   2. 中序遍历是指，对于树中的任意节点来说，先打印它的左子树，然后再打印它本身，最后打印它的右子树。
   3. 后序遍历是指，对于树中的任意节点来说，先打印它的左子树，然后再打印它的右子树，最后打印这个节点本身。
 
 * 实际上，二叉树的前、中、后序遍历就是一个递归的过程
   ` 写递归代码的关键，就是看能不能写出递推公式，而写递推公式的关键就是，如果要解决问题 A，
      就假设子问题 B、C 已经解决，然后再来看如何利用 B、C 来解决 A。
      所以，我们可以把前、中、后序遍历的递推公式都写出来。`
   ```
    前序遍历的递推公式：preOrder(r) = print r->preOrder(r->left)->preOrder(r->right)
    中序遍历的递推公式：inOrder(r) = inOrder(r->left)->print r->inOrder(r->right)
    后序遍历的递推公式：postOrder(r) = postOrder(r->left)->postOrder(r->right)->print r
    ```
    ```
    void preOrder(Node* root) {
      if (root == null) return;
      print root // 此处为伪代码，表示打印root节点
      preOrder(root->left);
      preOrder(root->right);
    }
    
    void inOrder(Node* root) {
      if (root == null) return;
      inOrder(root->left);
      print root // 此处为伪代码，表示打印root节点
      inOrder(root->right);
    }
    
    void postOrder(Node* root) {
      if (root == null) return;
      postOrder(root->left);
      postOrder(root->right);
      print root // 此处为伪代码，表示打印root节点
    }
    ``` 
    
   
 散列表：插入删除查找都是O(1), 是最常用的，但其缺点是不能顺序遍历以及扩容缩容的性能损耗。适用于那些不需要顺序遍历，数据更新不那么频繁的。
 
 跳表：插入删除查找都是O(logn), 并且能顺序遍历。缺点是空间复杂度O(n)。适用于不那么在意内存空间的，其顺序遍历和区间查找非常方便。
 
 红黑树：插入删除查找都是O(logn), 中序遍历即是顺序遍历，稳定。缺点是难以实现，去查找不方便。其实跳表更佳，但红黑树已经用于很多地方了。
 2018-12-02
 
 堆排序是一种原地的、时间复杂度为 O(nlogn) 的排序算法
 
 原地排序（Sorted in place）。原地排序算法，就是特指空间复杂度是 O(1) 的排序算法
 
 稳定性。这个概念是说，如果待排序的序列中存在值相等的元素，经过排序之后，相等元素之间原有的先后顺序不变。
 
 
   