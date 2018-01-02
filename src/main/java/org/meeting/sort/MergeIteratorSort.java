package org.meeting.sort;


/**
 * 非递归(迭代)实现的归并排序(自底向上)
 *
 * @Author: chenqimiao
 * @Date: 2017/12/4 13:34
 * @Since JDK 1.8
 */
public class MergeIteratorSort extends MergeSort {
    @Override
    public void sort(int[] a) {
        int size = a.length;

        int left, mid, right;

        for (int i = 1; i < size; i = i * 2) {
            //后一个数组存在
            left = 0;
            while (left + i < size) {
                mid = left + i - 1;
                right = mid + i < size ? mid + i : size - 1;
                merge(a, left, mid, right);
                left = right + 1;
            }
        }
    }


    public static void main(String args[]) {
        Sort sort = SortFactory.newInstance(MergeIteratorSort.class);

        int size = 100;
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = size - 1 - i;

        }

        sort.sort(a);

    }
}
