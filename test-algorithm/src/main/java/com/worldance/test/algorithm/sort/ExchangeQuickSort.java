package com.worldance.test.algorithm.sort;

import java.util.Arrays;

public class ExchangeQuickSort {

    public static void main(String[] args) {
        int[] array = {8, 1, 12, 4, 9, 3, 11, 5, 2, 7, 0, 6};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    // Medium-of-Three Partitioning
    public static int selectPivot(int[] array, int left, int right) {
        int middle = (left + right) / 2;
        if (array[middle] > array[right]) {
            swap(array, middle, left);
        }
        if (array[left] > array[right]) {
            swap(array, left, right);
        }
        if (array[middle] > array[left]) {
            swap(array, left, middle);
        }
        return array[left];
    }

    public static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(array, left, right);
        sort(array, left, index - 1);
        sort(array, index + 1, right);
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = selectPivot(array, left, right);
        while (left < right) {
            while (left < right && array[right] >= pivot) {
                right--;
            }
            if (left < right) {
                array[left++] = array[right];
            }
            while (left < right && array[left] < pivot) {
                left++;
            }
            if (left < right){
                array[right--] = array[left];
            }
        }
        array[right] = pivot;
        return right;
    }


    public static void swap(int[] array, int left, int right){
        int value = array[left];
        array[left] = array[right];
        array[right] = value;
    }
}
