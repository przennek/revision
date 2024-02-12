package interview.algo;

import interview.datastructures.core.LinkedList;
import interview.datastructures.core.Pair;
import interview.datastructures.core.SPair;
import interview.datastructures.interf.List;

public class BSearch {


    public static <T extends Comparable<T>> boolean bSearch(List<T> list, T val) {
        QSort.sort(list);
        int mid = list.size() / 2;

        if(list.isEmpty()) {
            return false;
        }

        int cmpy = val.compareTo(list.get(mid));
        if(cmpy == 0) {
            return true;
        } else {
            SPair<List<T>> split = list.split(mid);
            split.getLeft().removeAt(mid);
            if(cmpy < 0) {
                return bSearch(split.getLeft(), val);
            } else {
                return bSearch(split.getRight(), val);
            }
        }
    }
}
