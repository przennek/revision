package interview.datastructures;

import interview.datastructures.core.LinkedList;
import interview.datastructures.core.TrieNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

class TrieNodeTest {

    @Test
    public void oneBigTest() {
        // given
        TrieNode root = new TrieNode();

        // when
        boolean firstInsert = root.insert("COME");
        boolean secondInsert = root.insert("UNEVEN");
        boolean thirdInsert = root.insert("COME");
        root.insert("UNDONE");
        root.insert("THE");
        root.insert("IS");
        root.insert("SHINING");
        root.insert("AND");
        root.insert("SO");
        root.insert("ARE");
        root.insert("YOU");

        // then
        assertThat(firstInsert, equalTo(true));
        assertThat(secondInsert, equalTo(true));
        assertThat(thirdInsert, equalTo(false));

        // when
        LinkedList<String> contents = root.asList();

        // then
        assertThat(contents, equalTo(new LinkedList<>("AND", "ARE", "COME", "IS", "SHINING", "SO", "THE", "UNDONE", "UNEVEN", "YOU")));

        // when
        boolean present = root.search("COME");
        boolean notPresent = root.search("UNDO");
        boolean notPresent2 = root.search("UNDERCOVER");

        // then
        assertThat(present, equalTo(true));
        assertThat(notPresent, equalTo(false));
        assertThat(notPresent2, equalTo(false));

        // when
        root.delete("UNDONE");
        root.delete("UNEV");

        // then
        assertThat(root.asList(), equalTo(new LinkedList<>("AND", "ARE", "COME", "IS", "SHINING", "SO", "THE", "UNEVEN", "YOU")));
    }
}