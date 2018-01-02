package org.meeting.sort;


/**
 * 分类 -------------- 内部比较排序
 * 数据结构 ---------- 数组
 * 最差时间复杂度 ---- O(nlogn)
 * 最优时间复杂度 ---- O(nlogn)
 * 平均时间复杂度 ---- O(nlogn)
 * 所需辅助空间 ------ O(1)
 * 稳定性 ------------ 不稳定
 *
 * @Author: chenqimiao
 * @Date: 2017/12/4 16:24
 * @Since JDK 1.8
 */
public class HeapSort implements Sort {


    public void swap(int a[], int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }


    /**
     * 从i开始向下调整堆
     *
     * @param a    数组
     * @param i    头结点
     * @param size 待排序的数组大小
     */
    public void heapify(int[] a, int i, int size) {
        int max = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < size && a[leftChild] > max) {
            max = leftChild;
        }

        if (rightChild < size && a[rightChild] > max) {
            max = rightChild;
        }

        if (max != i) {
            swap(a, max, i);
            heapify(a, max, size);
        }
    }


    public void buildHeap(int[] a) {
        int size = a.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(a, i, a.length);
        }
    }

    @Override
    public void sort(int[] a) {
        buildHeap(a);

        int heapSize = a.length;

        while (heapSize > 1) {
            swap(a, 0, --heapSize);  //将当前堆的大小自减一，并把这个值作为当前堆最后一个数的索引传递给swap函数
            heapify(a, 0, heapSize);
        }
    }

    public static void main(String args[]) {
        Sort sort = SortFactory.newInstance(HeapSort.class);

        int a[] = {5, 2, 9, 4, 7, 6, 1, 3, 8};// 从小到大堆排序


        sort.sort(a);


    }


}
