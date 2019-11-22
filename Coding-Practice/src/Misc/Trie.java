package Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Trie {
    static final int ALPHABET_SIZE = 26;
    char[] chars = new char[]{'a' , 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    List<String> result = new ArrayList<>();

    private class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        TrieNode()
        {
            isEndOfWord = false;
            for(int i = 0; i < ALPHABET_SIZE; i++)
            {
                children[i] = null;
            }
        }
    }

    TrieNode root = new TrieNode();

    public void insert(String key)
    {
        key = key.toLowerCase();
        int level;
        int length = key.length();

        int index;

        TrieNode curr = root;

        for(level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if(curr.children[index] == null)
                curr.children[index] = new TrieNode();

            curr = curr.children[index];
        }

        curr.isEndOfWord = true;
    }

    private List<String> autoComplete(String st)
    {
        int level;
        int length = st.length();
        int index;
        TrieNode curr = root;
        result = new ArrayList<>();

        for (level = 0; level < length; level++)
        {
            index = st.charAt(level) - 'a';

            if (curr.children[index] == null)
                return new ArrayList<>();

            curr = curr.children[index];
        }

        if((curr != null || curr.isEndOfWord))
        {
            if(curr.isEndOfWord)
                result.add(st);
            helper(st, curr.children);
        }

        return result;
    }

    private void helper(String st, TrieNode[] children) {

        for(int i = 0; i < ALPHABET_SIZE; i++)
        {
            TrieNode curr = children[i];
            String str = st;

            if(curr != null)
            {
                str = str + chars[i];

                if(curr.isEndOfWord)
                {
                    result.add(str);
                }

                helper(str, curr.children);
            }
        }
    }

    private static List<List<String>> threeProductSuggestions(int numProducts,List<String> repository, String customQuery)
    {
        List<List<String>> autoCompleteResult = new ArrayList<>();

        Trie trie = new Trie();

        for(String repo : repository)
        {
            trie.insert(repo);
        }

        String st = customQuery.substring(0, 2);

        for(int i = 2; i < customQuery.length(); i++)
        {
            autoCompleteResult.add(new ArrayList<>(trie.autoComplete(st)));

            st = st + customQuery.charAt(i);
        }

        return autoCompleteResult;
    }

    public static void main(String[] args) {
        System.out.println(threeProductSuggestions(5, Arrays.asList("mobile", "mouse", "moneypot", "monitor", "mousepad"), "mouse"));

    }
}