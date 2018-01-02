package org.meeting.sort;


/**
 * 二分插入排序，平均时间复杂度为o(n^2)
 * @Author: chenqimiao
 * @Date: 2017/12/1 14:57
 * @Since JDK 1.8
 */
public class InsertionSortDichotomy implements Sort{

    @Override
    public void sort(int[] a) {
        int size = a.length;

        for (int i = 1 ; i <size ; i++){ //选数的遍历
            int get = a[i];

            int left = 0 ;
            int right = i-1;

            while (left <= right){  //二分查找一个left索引
                int mid = ( left + right ) /2;

                if(get > a[mid]){
                    left = mid + 1 ;
                }else {
                    right = mid -1;
                }
            }


            for (int j = i-1; j >= left ; j--){  //此索引到有序队列的末尾的所有元素往后移动一个节点
                a[j+1] = a[j];
            }

            a[left] = get;

        }
    }



    public static void main(String args[]){
        Sort sort = SortFactory.newInstance(InsertionSortDichotomy.class);

        int size =50;
        int[] a = new int[size];
        for (int i = 0; i<size; i++){
            a[i] = size-1-i;

        }

        sort.sort(a);

    }
}
