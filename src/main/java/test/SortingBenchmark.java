package test;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortingBenchmark {
    public static void main(String[] args) {
        List<Integer> list = generateRandomList(1000000); // Thay đổi kích thước danh sách cần sắp xếp

        long startTime;
        long endTime;
        long duration;

        // Đo thời gian của phiên bản không đệ quy
        List<Integer> list2 = new ArrayList<>(list);
        startTime = System.nanoTime();
        MergeSort.mergeSort(list2);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        System.out.println("Thời gian chạy của Merge Sort: " + duration + " ms");

        // Đo thời gian của phiên bản dùng đệ quy
        List<Integer> list1 = new ArrayList<>(list);
        startTime = System.nanoTime();
        MergeSortRecursive sort=new MergeSortRecursive(list1);
        var rs2=sort.mergeSort();
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        System.out.println("Thời gian chạy của Quick Sort đệ quy: " + duration + " ms");
        System.out.println("Kết quả: " + alike(list2, rs2));
    }

    public static boolean alike(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) return false;
        }
        return true;
    }

    public static List<Integer> generateRandomList(int size) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(1000)); // Thêm số ngẫu nhiên từ 0 đến 999 vào danh sách
        }
        return list;
    }
}
