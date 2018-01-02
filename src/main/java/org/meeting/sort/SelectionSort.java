package org.meeting.sort;

/**
 * 选择排序
 * 平均时间复杂度为o(n^2)
 *
 * @Author: chenqimiao
 * @Date: 2017/11/30 16:56
 * @Since JDK 1.8
 */
public class SelectionSort implements Sort{
    @Override
    public void sort(int[] a) {
        int size = a.length;

        for (int i = 0 ; i < size-1 ; i++ ){
            int min = i;
            for (int j = i+1 ; j < size ; j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }

            swap(a,min,i);
        }
    }

    private void swap(int[] a, int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }


    public static void main(String args[]){
        Sort sort = SortFactory.newInstance(SelectionSort.class);

        int size =1000;
        int[] a = new int[size];
        for (int i = 0; i<size; i++){
            a[i] = size-1-i;

        }

        sort.sort(a);

    }
}
