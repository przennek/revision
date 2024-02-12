package interview.excercise.chapter3;

import interview.datastructures.core.Stack;

public class StackSort {

    public static <T extends Comparable<T>> Stack<T> betterSort(Stack<T> a) {
        Stack<T> b = new Stack<>();
        while(!a.isEmpty()) {
            T ai = a.pop();
            if(b.isEmpty()) {
                b.push(ai);
            } else {
                T bx = b.peek();
                if(bx.compareTo(ai) > 0) {
                    a.push(b.pop());
                    a.push(ai);
                } else {
                    b.push(ai);
                }
            }
        }
        return b;
    }

    public static <T extends Comparable<T>> void sort(Stack<T> a) {
        Stack<T> b = new Stack<>();
        T oldPivot = null;
        T newestRepeatingPivot = null;

        while (true) {
            T pivot = a.pop();
            if (pivot == oldPivot) {
                b.push(pivot);
                newestRepeatingPivot = pivot;
                if (a.isEmpty()) {
                    break;
                }
                continue;
            }
            pushAllGT(pivot, a, b);
            a.push(pivot);
            pushBack(a, b, newestRepeatingPivot);
            oldPivot = pivot;
        }
        while(!b.isEmpty()) {
            a.push(b.pop());
        }
    }

    static <T extends Comparable<T>> void pushAllGT(T p, Stack<T> a, Stack<T> b) {
        while (!a.isEmpty()) {
            T c = a.pop();
            T tmp = null;
            T tbs = null;
            if (c.compareTo(p) > 0) {
                b.push(c);
            } else {
                tmp = c;
                while (c.compareTo(p) <= 0) {
                    b.push(c);
                    if(a.isEmpty()) {
                        break;
                    } else {
                        c = a.pop();
                    }
                }
                tbs = c;
                boolean stopper = a.isEmpty();
                while (true) {
                    c = b.pop();
                    a.push(c);
                    if (c == tmp) break;
                }
                if(tbs.compareTo(p) > 0) {
                    b.push(tbs);
                }
                if (stopper) break;
            }
        }
    }

    static <T extends Comparable<T>> void pushBack(Stack<T> a, Stack<T> b, T stopper) {
        T tbs = null;
        while (!b.isEmpty()) {
            tbs = b.pop();
            if (tbs.equals(stopper)) {
                b.push(tbs);
                break;
            } else {
                a.push(tbs);
            }
        }
    }
}
