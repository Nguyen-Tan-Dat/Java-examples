package test;

import java.util.Arrays;
import java.util.Stack;

public class NonRecursiveQuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = arr.length - 1;

        stack.push(left);
        stack.push(right);

        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();

            int pivotIndex = partition(arr, left, right);

            if (pivotIndex - 1 > left) {
                stack.push(left);
                stack.push(pivotIndex - 1);
            }

            if (pivotIndex + 1 < right) {
                stack.push(pivotIndex + 1);
                stack.push(right);
            }
        }
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
