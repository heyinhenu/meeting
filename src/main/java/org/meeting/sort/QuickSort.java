package org.meeting.sort;

/**
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

    public void swap(int a[], int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }

    public int partition(int[] a, int left, int right) {
        int tail = left - 1;

        int pivot = right;

        for (int i = left; i < right; i++) {
            if (a[i] < a[pivot]) {
                swap(a, ++tail, a[i]);
            }
        }
        swap(a, tail + 1, right);

        return tail + 1;
    }

    public void quickSort(int[] a, int left, int right) {
        if (left >= right){
            return;
        }
        int pivot = partition(a, left, right);
        quickSort(a, left, pivot - 1);
        quickSort(a, pivot + 1, right);
    }

    @Override
    public void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }


    public static void main(String args[]) {
        Sort sort = SortFactory.newInstance(QuickSort.class);
        int size = 10;
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = size - 1 - i;

        }
        sort.sort(a);
    }
}
