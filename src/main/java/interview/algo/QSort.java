package interview.algo;

import interview.datastructures.interf.List;

public class QSort {
    public static <T extends Comparable<T>> void sort(List<T> list) {
        sort(list, 0, list.size());
    }

    private static <T extends Comparable<T>> void sort(List<T> list, int start, int end) {
        if (start < end) {
            int pivot = pivot(list, start, end);
            sort(list, start, pivot);
            sort(list, pivot + 1, end);
        }
    }

    public static <T extends Comparable<T>> int pivot(List<T> list, int start, int end) {
        T pivot = list.get(end - 1);
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if ((list.get(j)).compareTo(pivot) <= 0) {  // item to the right <= pivot
                list.swap(++i, j);
            }
        }

        return i;
    }
}
