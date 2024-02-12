package interview.excercise.chapter4;

import interview.datastructures.core.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BuildDependencyTree {

    public List<String> buildOrder(String[] symbols, List<Pair<String, String>> pairs) {
        List<String> out = new ArrayList<>();
        Map<String, Integer> mapping = buildMapping(symbols);
        boolean matrix[][] = buildAdjacencyMatrix(mapping, pairs);
        while(!mapping.keySet().isEmpty()) {
            boolean anyZero = false;
            Set<String> toBeRemoved = new HashSet<>();
            for(String c : mapping.keySet()) {
                if(isZeroA(matrix, mapping.get(c), symbols.length)) {
                    out.add(symbols[mapping.get(c)]);
                    zeroC(matrix, mapping.get(c), symbols.length);
                    toBeRemoved.add(symbols[mapping.get(c)]);
                    anyZero = true;
                }
            }
            if(!anyZero) {
                throw new RuntimeException("Build is screwed.");
            }
            toBeRemoved.forEach(mapping::remove);
        }
        return out;
    }

    private boolean[][] buildAdjacencyMatrix(Map<String, Integer> symbols,
                                             List<Pair<String, String>> p) {
        int size = symbols.keySet().size();
        boolean[][] matrix = new boolean[size][size];
        for(Pair<String, String> next : p) {
            matrix[symbols.get(next.getLeft())][symbols.get(next.getRight())] = true;
        }
        return matrix;
    }

    private Map<String, Integer> buildMapping(String[] symbols) {
        Map<String, Integer> o = new HashMap<>();
        for(int i = 0; i < symbols.length; i++) {
            o.put(symbols[i], i);
        }
        return o;
    }

    private boolean isZeroA(boolean[][] m, int toVal, int len) {
        for(int i = 0; i < len; i++) {
            if(m[i][toVal]) {
                return false;
            }
        }
        return true;
    }

    private void zeroC(boolean[][] m, int fVal, int len) {
        for(int i = 0; i < len; i++) {
            m[fVal][i] = false;
        }
    }

}
