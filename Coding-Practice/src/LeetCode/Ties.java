package LeetCode;

public class Ties {
    public static class Node {
        private int numberOfCharacter = 26;
        Node[] children = new Node[numberOfCharacter];
        int size;

        private static int getCharIndex(char c) {
            return c - 'a';
        }

        private Node getNode(char c) {
            return children[getCharIndex(c)];
        }

        private void setNode(char c, Node node) {
            children[getCharIndex(c)] = node;
        }

        public void add (String s) {
            add(s, 0);
        }

        private void add(String s, int index) {
            size++;
            if (index == s.length())
                return;
            char currChar = s.charAt(index);
            Node childNode = children[getCharIndex(currChar)];
            if (childNode == null) {
                childNode = new Node();
                setNode(currChar, childNode);
            }
            childNode.add(s, index+1);
        }

        private int findCount(String s, int index)  {
            if (index == s.length()) {
                return size;
            }
            char c = s.charAt(index);
            Node child = getNode(c);
            if (child == null) {
                return 0;
            }

            return findCount(s, index+1);
        }
    }
}
