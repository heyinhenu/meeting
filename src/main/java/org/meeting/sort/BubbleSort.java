package org.meeting.sort;


/**
 * 冒泡排序
 * 平均时间复杂度为o(n^2)
 *
 * @Author: chenqimiao
 * @Date: 2017/11/30 16:23
 * @Since JDK 1.8
 */
public class BubbleSort implements Sort {

    @Override
    public void sort(int[] a) {
        int size = a.length;
        for (int i = 0; i < size - 1; i++) {  //选数的遍历
            //将最优时间复杂度由o(n^2)优化到o(n)
            boolean nextIsNeedSwap = false;
            for (int j = 0; j < size - i - 1; j++) {   //比较的遍历
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    nextIsNeedSwap = true;
                }
            }
            if (!nextIsNeedSwap)
                break;
        }
    }

    private void swap(int[] a, int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }


    public static void main(String args[]) {
        Sort sort = SortFactory.newInstance(BubbleSort.class);
        int size = 1000;
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = size - 1 - i;

        }
        sort.sort(a);
    }
}
