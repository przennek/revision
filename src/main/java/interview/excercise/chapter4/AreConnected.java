package interview.excercise.chapter4;

import interview.excercise.chapter4.datastructures.Graph.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class AreConnected {

    public static boolean areConnected(Node a, Node b) {
        Set<Node> va = new HashSet<>();
        Set<Node> vb = new HashSet<>();

        Queue<Node> qA = new LinkedList<>();
        Queue<Node> qB = new LinkedList<>();

        qA.add(a);
        qB.add(b);

        while (!qA.isEmpty() || !qB.isEmpty()) {
            if(!qA.isEmpty()) {
                Node ra = qA.remove();
                va.add(ra);
                if (vb.contains(ra)) return true;
                for (Node na : ra.children) {
                    if (!va.contains(na)) {
                        qA.add(na);
                    }
                }
            }

            if(!qB.isEmpty()) {
                Node rb = qB.remove();
                vb.add(rb);
                if (va.contains(rb)) return true;

                for (Node nb : rb.children) {
                    if (!vb.contains(nb)) {
                        qB.add(nb);
                    }
                }
            }
        }
        return false;
    }
}
