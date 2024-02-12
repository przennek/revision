package interview.datastructures;

import interview.datastructures.core.DiGraph;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class DiGraphTest {

    @Test
    public void shouldCreateGraph() throws IOException {
        DiGraph diGraph = new DiGraph(5);
        diGraph.addNode(1, 0);
        diGraph.addNode(2, 1);
        diGraph.addNode(0, 0);
        diGraph.addNode(3, 2);
        diGraph.addNode(2, 3);
        diGraph.addNode(3, 4);
        diGraph.addNode(4, 1);
        String path = "/Users/pc/IdeaProjects/datastructures_from_scratch/src/test/res/out.dot";
        Files.write(Paths.get(path), diGraph.getDotContents().getBytes());
        // dot -Tpdf out.dot > out.pdf
    }

}