package interview.datastructures.core;

// TODO
public class DiGraph {

    private final boolean[][] adjacency;
    private final int numNodes;

    public DiGraph(int numNodes) {
        adjacency = new boolean[numNodes][numNodes];
        this.numNodes = numNodes;
    }

    public boolean addNode(int from, int to) {
        if(hasNode(from, to)) {
            return false;
        }

        adjacency[from][to] = true;
        return true;
    }

    public boolean hasNode(int from, int to) {
        return adjacency[from][to];
    }

    public String getDotContents() {
        String buffer = "digraph {\n";
        for(int from = 0; from < numNodes; from++) {
            for(int to = 0; to < numNodes; to++) {
                if(hasNode(from, to)) {
                    buffer += String.format("%d -> %d;\n", from, to);
                }
            }
        }
        buffer += "}";
        return buffer;
    }
}
