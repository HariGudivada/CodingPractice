package MicrosoftPre;
//151
public class ReverseWords {
    public static String reverseWords(String s) {

        if (s == null || s.length() == 0) {
            return null;
        }
        s.trim();
        String[] words = s.split("\\s+");
        int l =0;
        int r = words.length-1;
        while (l<r) {
            String temp = words[l];
            words[l] = words[r];
            words[r] = temp;
            l++;
            r--;
        }
        String result = words[0];
        for (int i = 1; i < words.length;i++) {
            result += " "+ words[i];
        }
        return result;
    }

    public static void main(String[] args) {
        String words =  " hello!  world ";
        System.out.println(reverseWords(words));
    }
}
