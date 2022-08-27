package com.worldance.test.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序-堆排序(不太对！)
 */
public class SelectHeap {

    public static void main(String[] args) {
//        int[] array = { 15, 13, 12, 5, 20, 1, 8, 9 };
        int[] array = {91, 60, 96, 13, 35, 65, 46, 65, 10, 30, 20, 31, 77, 81, 22 };
        createHeap(array, array.length - 1);
        System.out.println(Arrays.toString(array));

        deleteHeap(array, array.length - 1);
        System.out.println(Arrays.toString(array));

        deleteHeap(array, array.length - 2);
        System.out.println(Arrays.toString(array));

        insertHeap(array, 3, array.length - 2);
        System.out.println(Arrays.toString(array));
    }

    private static void createHeap(int[] arr, int n) {
        for (int i = (n - 1) / 2; i > 0; i--) {
            percolatrDown(arr, i, n);
        }
    }

    // 插入
    private static void insertHeap(int[] array, int data, int n) {
        array[n] = data;
        percolatrUp(array, n);
    }

    // 删除栈顶元素
    private static void deleteHeap(int[] arr, int n) {
        arr[0] = arr[n];
        arr[n] = -1;
        percolatrDown(arr, 0, n - 1);
    }

    // 上浮
    private static void percolatrUp(int[] array, int n) {
        int data = array[n];
        int father = (n - 1) / 2;
        while (data < array[father] && father >= 0) {
            array[n] = array[father];
            array[father] = data;
            n = father;
            father = (n - 1) / 2;
        }
        array[father] = data;
    }

    /**
     * 下滤
     * @param arr
     * @param i
     * @param n
     */
    private static void percolatrDown(int[] arr, int i, int n) {
        int father = arr[i];
        int child = 2 * i + 1;
        // 遍历整个该根节点的子树
        while (child <= n) {
            // 定位左右结点小的那一个
            if (child + 1 <= n && arr[child + 1] < arr[child]) {
                child += 1;
            }
            // 若根结点比子结点小，说明已经是个小堆
            if (father < arr[child]) {
                break;
            }
            // 互换根结点和子结点
            arr[i] = arr[child];
            arr[child] = father;
            // 重新定位根节点和子结点
            i = child;
            child = i * 2 + 1;
        }
    }


}
