package com.worldance.test.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序-简单选择排序
 *  1.从未排序的初始数组中寻找最小元素放置首位。
 *  2.从剩余元素中继续寻找最小元素，放到已排序序列的尾部
 *  3.遍历数组，直至结束。
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {8, 12, 1, 4, 9, 3, 5, 2, 7, 0, 6, 11};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
    private static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[index] > array[j]) {
                    index = j;
                }
            }
            swap(array, i, index);
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
