package test;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int length = arr.length;
        quickSortRecursive(arr, 0, length - 1);
    }

    private static void quickSortRecursive(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(arr, left, right);
        quickSortRecursive(arr, left, pivotIndex - 1);
        quickSortRecursive(arr, pivotIndex + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {12, 4, 5, 6, 7, 3, 1, 15};
        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(arr));
    }
}

