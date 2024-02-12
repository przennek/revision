package interview.datastructures.core;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    public void shouldAdd() {
        // given
        HashTable<String, Integer> appleCounter = new HashTable<>();

        // when
        appleCounter.put("Przemek", 3);
        appleCounter.put("Karolina", 5);
        appleCounter.put("Majlo", 1);
        appleCounter.put("MyFriend", 0);

        appleCounter.remove("MyFriend");

        // then
        assertThat(appleCounter.get("Przemek"), equalTo(Optional.of(3)));
        assertThat(appleCounter.keySet(), equalTo(new Set<>("Przemek", "Karolina", "Majlo")));
    }

    @Test
    public void shouldResize() {
        // given
        HashTable<Integer, Integer> ii = new HashTable<>();

        // when
        ii.put(1, 1);
        ii.put(2, 2);
        ii.put(3, 3);
        ii.put(4, 1);
        ii.put(5, 1);
        ii.put(6, 1);
        ii.put(7, 1);
        ii.put(8, 1);
        ii.put(9, 1);
        ii.put(10, 1);
        ii.put(11, 1);
        ii.put(12, 1);


        // then
        assertThat(ii.count(), equalTo(12));
    }

}