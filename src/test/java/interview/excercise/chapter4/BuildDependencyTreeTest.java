package interview.excercise.chapter4;

import interview.datastructures.core.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class BuildDependencyTreeTest {

    @Test
    public void shouldBuildDependencyTree() {
        // given
        String[] symbols = new String[]{"a", "b", "c", "d", "e", "f"};
        List<Pair<String, String>> deps = new ArrayList<>() {{
            add(new Pair<>("a", "d"));
            add(new Pair<>("f", "b"));
            add(new Pair<>("b", "d"));
            add(new Pair<>("f", "a"));
            add(new Pair<>("d", "c"));
        }};

        // when
        List<String> out = new BuildDependencyTree().buildOrder(symbols, deps);

        // then
        assertThat(out, equalTo(List.of("e", "f", "a", "b", "d", "c")));
    }

    @Test
    public void buildShouldBeScrewed() {
        // given
        String[] symbols = new String[]{"a", "b", "c"};
        List<Pair<String, String>> deps = new ArrayList<>() {{
            add(new Pair<>("a", "b"));
            add(new Pair<>("b", "c"));
            add(new Pair<>("c", "a"));
        }};

        // when
        boolean screwed = false;
        try {
            List<String> out = new BuildDependencyTree().buildOrder(symbols, deps);
        } catch (Exception e) {
            screwed = true;
        }

        // then
        assert screwed;
    }
}