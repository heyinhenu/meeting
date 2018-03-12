package org.meeting.sort;

/**
 * http://blog.csdn.net/yzllz001/article/details/50982841
 * 分类 ------------ 内部比较排序
 * 数据结构 --------- 数组
 * 最差时间复杂度 ---- 每次选取的基准都是最大（或最小）的元素，导致每次只划分出了一个分区，需要进行n-1次划分才能结束递归，时间复杂度为O(n^2)
 * 最优时间复杂度 ---- 每次选取的基准都是中位数，这样每次都均匀的划分出两个分区，只需要logn次划分就能结束递归，时间复杂度为O(nlogn)
 * 平均时间复杂度 ---- O(nlogn)
 * 所需辅助空间 ------ 主要是递归造成的栈空间的使用(用来保存left和right等局部变量)，取决于递归树的深度，一般为O(logn)，最差为O(n)
 * 稳定性 ---------- 不稳定
 *
 * @Author: chenqimiao
 * @Date: 2017/12/5 10:59
 * @Since JDK 1.8
 */
public class QuickSort implements Sort {

    public void quickSort(int[] a, int left, int right) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "   ");
        }
        System.out.println();
        int i, j, t, pivot;
        if (left > right) {
            return;
        }
        pivot = a[left];
        i = left;
        j = right;
        while (i != j) {
            while (a[j] >= pivot && i < j) {
                j--;
            }
            while (a[i] <= pivot && i < j) {
                i++;
            }
            if (i < j) {
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        a[left] = a[i];
        a[i] = pivot;
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }

    @Override
    public void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public static void main(String args[]) {
        Sort sort = SortFactory.newInstance(QuickSort.class);
        int size = 10;
        int[] a = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        sort.sort(a);
    }
}
