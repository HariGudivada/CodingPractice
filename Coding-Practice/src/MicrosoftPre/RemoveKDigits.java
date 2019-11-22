package MicrosoftPre;

import java.util.Stack;

//402
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) {
            return "0";
        }

        if (k == num.length()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        int counter = 0;
        while (counter < num.length()) {
            while(k>0 && sbLength > 0 && sb.charAt(sbLength-1) > num.charAt(counter)) {
                sb.deleteCharAt(sbLength-1);
                sbLength--;
                k--;
            }
            sb.append(num.charAt(counter));
            sbLength++;
            counter++;
        }
        while (sb.length() >1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        removeKDigits.removeKdigits("112", 1);
    }
}
