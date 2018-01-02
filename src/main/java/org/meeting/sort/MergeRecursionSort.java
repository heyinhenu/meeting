package org.meeting.sort;


/**
 * 递归实现的归并排序(自顶向下)
 *
 * @Author: chenqimiao
 * @Date: 2017/12/4 13:33
 * @Since JDK 1.8
 */
public class MergeRecursionSort extends MergeSort {

    @Override
    public void sort(int[] a) {
        mergeSortRecursion(a, 0, a.length - 1);
    }

    private void mergeSortRecursion(int[] a, int left, int right) {
        if (left == right)
            return;
        int mid = (left + right) / 2;
        mergeSortRecursion(a, left, mid);
        mergeSortRecursion(a, mid + 1, right);
        merge(a, left, mid, right);
    }


    public static void main(String args[]) {
        Sort sort = SortFactory.newInstance(MergeRecursionSort.class);

        int size = 1000;
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = size - 1 - i;

        }

        sort.sort(a);
    }
}
