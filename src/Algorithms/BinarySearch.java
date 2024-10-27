package Algorithms;

import java.util.List;

public class BinarySearch {

    public static <T extends Comparable<T>> int binarySearch(List<T> list, T value) {
        if (list.isEmpty()){
            return -1;
        }
        return binarySearchPartition(list, 0, list.size() - 1, value);
    }

    private static <T extends Comparable<T>> int binarySearchPartition(List<T> list, int low, int high, T value) {
        if (low > high) {
            return -2;
        }

        int pivotIndex = low + (high - low) / 2;

        if (value.compareTo(list.get(pivotIndex)) == 0) {
            return pivotIndex;
        } else if (value.compareTo(list.get(pivotIndex)) < 0) {
            return binarySearchPartition(list, low, pivotIndex - 1, value);
        } else {
            return binarySearchPartition(list, pivotIndex + 1, high, value);
        }
    }
}
