package Algorithms;

import java.util.List;

public class QuickSort {

    public static <T extends Comparable<T>> void quickSort(List<T> list) {
        int low = 0;
        int high = list.size()-1;
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSortPartition(list, low, pivotIndex - 1);
            quickSortPartition(list, pivotIndex + 1, high);
        }
    }
    public static <T extends Comparable<T>> void quickSortPartition(List<T> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSortPartition(list, low, pivotIndex - 1);
            quickSortPartition(list, pivotIndex + 1, high);
        }
    }
    private static <T extends Comparable<T>> int partition(List<T> list, int low, int high) {
        T pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) < 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private static <T> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
