package org.meeting.sort;

/**
 * 希尔排序
 *
 * @Author: chenqimiao
 * @Date: 2017/12/1 16:03
 * @Since JDK 1.8
 */
public class ShellSort implements Sort {
    @Override
    public void sort(int[] a) {

        int size = a.length;

        int h = 0;

        while (h <= size) {
            h = 3 * h + 1;
        }

        while (h >= 1) {  //步长的遍历

            for (int i = h; i < size; i++) { //将步长为h的归为一组。遍历每一组。//选数的遍历

                int j = i - h; //已排序队列中的最后一个元素

                int get = a[i]; //待排序队列中的第一个元素

                while (j >= 0 && a[j] > get) {   ///在对应的分组的进行插入比较
                    a[j + h] = a[j];
                    j = j - h;
                }

                a[j + h] = get;
            }
            h = (h - 1) / 3;

        }

    }


    public static void main(String args[]) {
        Sort sort = SortFactory.newInstance(ShellSort.class);

        int size = 10;
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = size - 1 - i;

        }

        sort.sort(a);

    }
}
