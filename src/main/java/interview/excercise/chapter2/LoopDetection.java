package interview.excercise.chapter2;

import interview.excercise.chapter2.datastructures.Node;

import java.util.HashSet;
import java.util.Set;

public class LoopDetection {
    public static <T> Node<T> loop(Node<T> a) {
        Set<Node<T>> visited = new HashSet<>();
        while(a.next != null) {
            if(visited.contains(a)) {
                return a;
            }
            visited.add(a);
            a = a.next;
        }
        return null;
    }
}
