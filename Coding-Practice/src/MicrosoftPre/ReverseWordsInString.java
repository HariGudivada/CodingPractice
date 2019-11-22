package MicrosoftPre;

import java.sql.SQLOutput;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String output = "";
        for (String word : words) {
            output += swap(word);
        }
        System.out.println(output);
        return output.trim();
    }

    public String swap(String word) {
        if (word == null || word.length() <= 0) {
            return "";
        }

        int j = word.length()-1 ;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < j; i++) {
            char temp = wordArray[i];
            wordArray[i] = wordArray[j];
            wordArray[j] = temp;
            j--;
        }

        return new String(wordArray)+ " ";
    }

    public static void main(String[] args) {
        ReverseWordsInString r = new ReverseWordsInString();
        r.reverseWords("Let's take LeetCode contest");
    }
}
