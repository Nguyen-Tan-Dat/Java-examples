package test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void mergeSort(List<Integer> arr) {
        if (arr == null || arr.size() <= 1) {
            return;
        }
        int length = arr.size();
        mergeSortRecursive(arr, 0, length - 1);
    }

    private static void mergeSortRecursive(List<Integer> arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortRecursive(arr, left, mid);
            mergeSortRecursive(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(List<Integer> arr, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        List<Integer> leftList = new ArrayList<>();
        for (int i = 0; i < leftSize; i++) {
            leftList.add(arr.get(left + i));
        }
        int i = 0, j = mid+1, k = left;
        while (i < leftSize && j <=right) {
            if (leftList.get(i) <= arr.get(j)) {
                arr.set(k, leftList.get(i));
                i++;
            } else {
                arr.set(k, arr.get(j));
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            arr.set(k, leftList.get(i));
            i++;
            k++;
        }
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(12, 4, 5, 6, 7, 3, 1, 15));
        System.out.println("Mảng ban đầu: " + arr);
        mergeSort(arr);
        System.out.println("Mảng sau khi sắp xếp: " + arr);
    }
}
