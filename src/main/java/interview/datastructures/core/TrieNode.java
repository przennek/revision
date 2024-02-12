package interview.datastructures.core;

import java.util.Arrays;
import java.util.Objects;

import static java.util.stream.IntStream.range;

public class TrieNode {
    private static final int CHILD_LEN = 256;
    private final TrieNode[] childs = new TrieNode[CHILD_LEN];
    boolean terminal;

    public TrieNode() {
        terminal = false;
        range(0, CHILD_LEN).forEach(i -> childs[i] = null);
    }

    public boolean insert(String value) {
        char[] text = value.toCharArray();
        int len = text.length;

        TrieNode current = this;
        for(int i = 0; i < len; i++) {
            if(current.childs()[text[i]] == null) {
                current.childs()[text[i]] = new TrieNode();
            }
            current = current.childs()[text[i]];
        }

        if(!current.isTerminal()) {
            current.setTerminal(true);
            return true;
        }

        return false;
    }

    public boolean search(String value) {
        char[] text = value.toCharArray();
        int len = text.length;

        TrieNode current = this;
        for(int i = 0; i < len; i++) {
            if(current.childs()[text[i]] == null) {
                return false;
            }
            current = current.childs[text[i]];
        }

        return current.isTerminal();
    }

    public void delete(String value) {
        deleteRec(this, value, "");
    }

    public boolean deleteRec(TrieNode node, String value, String textSoFar) {
        if(textSoFar.equals(value)) {
            if(node.isTerminal()) {
                node.setTerminal(false);
            }

            return Arrays.stream(node.childs()).noneMatch(Objects::nonNull);
        }

        char next = value.charAt(textSoFar.length());
        TrieNode child = node.childs()[next];

        if(child == null) {
            return false;
        }

        boolean delete = deleteRec(child, value, textSoFar + next);
        if(!delete) {
            return false;
        }

        if(Arrays.stream(node.childs()[next].childs()).noneMatch(Objects::nonNull)) {
            node.childs()[next] = null;
        } else {
            return false;
        }

        return true;
    }

    public LinkedList<String> asList() {
        LinkedList<String> contents = new LinkedList<>();
        getContents(childs, "", contents);
        return contents;
    }

    public void getContents(TrieNode[] childs, String prefix, LinkedList<String> contents) {
        for(int i = 0; i < CHILD_LEN; i++) {
            TrieNode child = childs[i];
            if(child != null) {
                String newPrefix = prefix + (char) i;
                getContents(child.childs, newPrefix, contents);
                if(child.isTerminal()) {
                    contents.add(newPrefix);
                }
            }
        }
    }

    public void setTerminal(boolean terminal) {
        this.terminal = terminal;
    }

    public boolean isTerminal() {
        return terminal;
    }

    public TrieNode[] childs() {
        return childs;
    }
}
