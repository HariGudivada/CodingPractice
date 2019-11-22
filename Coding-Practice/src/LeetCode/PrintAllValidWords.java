package LeetCode;

//https://www.geeksforgeeks.org/print-valid-words-possible-using-characters-array/
public class PrintAllValidWords {
    private static int SIZE = 26;

    private static class TrieNode {
        TrieNode[] child = new TrieNode[SIZE];
        boolean completeWord;

        public TrieNode() {
            completeWord = false;
            for (int i = 0; i < SIZE; i++)
                child[i] = null;
        }
    }

    public static void searchWords(TrieNode root, boolean hash[],
                               String str) {
        if (root.completeWord) {
            System.out.println(str);
        }
        for (int i = 0 ; i < root.child.length; i++) {
            if (hash[i] && root.child[i] != null) {
                char c = (char)(i+'a');
                searchWords(root.child[i], hash, str+c);
            }
        }

    }

    private static void PrintAllWords(char[] arr, TrieNode root, int n) {
        boolean[] hash = new boolean[SIZE];
        for (int i = 0 ; i < n; i++) {
            hash[arr[i] -'a'] = true;
        }

        TrieNode node = root;
        String str = "";
        for (int i = 0; i < SIZE ; i ++) {
            if (hash[i] && node.child[i] != null) {
                str += (char)(i+'a');
                searchWords(node.child[i], hash, str);
                str = "";
            }
        }
    }

    static void insert(TrieNode root, String key) {
        TrieNode node = root;
        int keyLength = key.length();
        for (int i = 0; i < keyLength; i++) {
            int index = key.charAt(i) - 'a';
            if (node.child[index] == null) {
                node.child[index] = new TrieNode();
            }
            node = node.child[index];
        }

        node.completeWord = true;
    }

    public static void main(String[] args) {
        // Let the given dictionary be following
        String Dict[] = {"go", "bat", "me", "eat",
                "goal", "boy", "run"} ;

        // Root Node of Trie
        TrieNode root = new TrieNode();

        // insert all words of dictionary into trie
        int n = Dict.length;
        for (int i=0; i<n; i++)
            insert(root, Dict[i]);

        char arr[] = {'e', 'o', 'b', 'a', 'm', 'g', 'l'};
        int N = arr.length;

        PrintAllWords(arr, root, N);
    }
}
