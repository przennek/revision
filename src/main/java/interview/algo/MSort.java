package interview.algo;

import interview.datastructures.core.LinkedList;
import interview.datastructures.core.Pair;
import interview.datastructures.core.SPair;
import interview.datastructures.interf.List;

public class MSort {

    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
        if (list.size() == 1) {
            return list;
        }

        SPair<List<T>> split = list.split((list.size() / 2) - 1);
        List<T> left = sort(split.getLeft());
        List<T> right = sort(split.getRight());

        LinkedList<T> joined = new LinkedList<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            T leftVal = left.get(0);
            T rightVal = right.get(0);
            if (leftVal.compareTo(rightVal) < 0) {
                joined.add(leftVal);
                left.removeAt(0);
            } else {
                joined.add(rightVal);
                right.removeAt(0);
            }
        }

        if (left.isEmpty()) {
            joined.addAll(right);
        } else {
            joined.addAll(left);
        }

        joined.print();
        return joined;
    }
}
