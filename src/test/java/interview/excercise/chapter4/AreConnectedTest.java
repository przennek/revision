package interview.excercise.chapter4;

import interview.excercise.chapter4.datastructures.Graph.Node;
import org.junit.jupiter.api.Test;

class AreConnectedTest {

    @Test
    public void areConnectedTest() {
        // given
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);

        n1.addChild(n2);
        n2.addChild(n3);
        n2.addChild(n4);
        n2.addChild(n5);
        n5.addChild(n6);
        n6.addChild(n7);
        n7.addChild(n8);
        n7.addChild(n9);
        n8.addChild(n9);

        //       --> 4
        //       |
        // 1 --> 2 --> 5 --> 6 --> 7 --> 9 <--
        //       |                 |         |
        //       --> 3             ----> 8 --

        // when
        boolean connected = AreConnected.areConnected(n1, n9);

        // then
        assert connected;
    }

    @Test
    public void areNotConnectedTest() {
        // given
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);

        n1.addChild(n2);
        n2.addChild(n3);
        n2.addChild(n4);
        n2.addChild(n5);
        n5.addChild(n6);
        n7.addChild(n8);
        n7.addChild(n9);
        n8.addChild(n9);

        //       --> 4
        //       |
        // 1 --> 2 --> 5 --> 6     7 --> 9 <--
        //       |                 |         |
        //       --> 3             ----> 8 --

        // when
        boolean connected = AreConnected.areConnected(n1, n9);

        // then
        assert !connected;
    }

}