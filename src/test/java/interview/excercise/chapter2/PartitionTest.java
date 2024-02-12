package interview.excercise.chapter2;

import interview.excercise.chapter2.datastructures.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartitionTest {

    @Test
    public void test() {
        // given
        Node<Integer> head = Node.createAndLink(
                Node.of(5),
                Node.of(3),
                Node.of(6),
                Node.of(1),
                Node.of(2),
                Node.of(4)
        );

        // when
        head = Partition.partition(head, 3);

        // then
        head.toArrayList().forEach(System.out::println);
    }

}