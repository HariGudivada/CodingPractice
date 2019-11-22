package MicrosoftPre;

public class ReverseWordsInStringII {
    public static void reverseWords(char[] s) {
        if(s.length == 0) {
            return;
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < s.length) {
            while(k < s.length && s[k]  != ' ' ) {
                k++;
            }
            j = k-1;
            while(i < j) {
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                i++;
                j--;
            }
            i = k+1;
            j = k+1;
            k++;
        }
        i =0;
        j = s.length-1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }

    }

    public static void main(String[] args) {
        char[] arr = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords(arr);
    }
}
