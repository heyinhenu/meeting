package org.meeting.sort;

/**
 * 归并排序
 * 最差时间复杂度 ---- O(nlogn)
 * 最优时间复杂度 ---- O(nlogn)
 * 平均时间复杂度 ---- O(nlogn)
 * 所需辅助空间 ------ O(n)
 *
 * @Author: chenqimiao
 * @Date: 2017/12/4 13:31
 * @Since JDK 1.8
 */
public abstract class MergeSort implements Sort {

    protected void merge(int a[], int left, int mid, int right){
        int len = right - left + 1;
        int[] temp = new int[len];
        int index = 0;

        int i = left;

        int j = mid + 1;

        while (i <= mid && j <= right){
            temp[index++] = a[i] <= a[j] ? a[i++] : a[j++];
        }

        while (i <= mid){
            temp[index++] = a[i++];
        }

        while (j <= right){
            temp[index++] = a[j++];
        }

        for (int k = 0; k < temp.length; k++){
            a[left++] = temp[k];
        }
    }
}

