package org.meeting.sort;

/**
 * @Author: chenqimiao
 * @Date: 2017/11/29 11:20
 * @Since JDK 1.8
 */
public class SortFactory {
    public static Sort newInstance(Class<? extends Sort> clazz) {
        try {
            return (Sort) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String args[]) {
        Sort sort = newInstance(BubbleSort.class);
    }

}
