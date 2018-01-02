package org.meeting.sort;


/**
 * 插入排序
 * 平均时间复杂度o(n^2),最优时间复杂度o(n)
 *
 * @Author: chenqimiao
 * @Date: 2017/12/1 10:19
 * @Since JDK 1.8
 */
public class InsertionSort implements Sort {

    @Override
    public void sort(int[] a) {
        int size = a.length;

        for (int i = 1; i < size; i++) {

            int get = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > get) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = get;
        }
    }


    public static void main(String args[]) {
        Sort sort = SortFactory.newInstance(InsertionSort.class);

        int size = 100000;
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = size - 1 - i;

        }

        sort.sort(a);

    }
}
