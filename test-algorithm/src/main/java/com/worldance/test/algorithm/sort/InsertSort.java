package com.worldance.test.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序-直接插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {8, 12, 1, 4, 9, 3, 5, 2, 7, 0, 6, 11};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
    private static void insertSort(int[] array) {

        int length = array.length;
        int temp;
        for (int i = 0; i <  length; i++) {
            temp = array[i];
            int index;
            for (index = i - 1; index >= 0; index--) {
                if (temp < array[index]) {
                    array[index + 1] = array[index];
                }
                else {
                    array[index + 1] = temp;
                    break;
                }
                if (index == 0) {
                    array[index] = temp;
                }
            }
        }


    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
