package MicrosoftPre;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReverseInteger {
    public int reverse(int x) {
        String s = Integer.toString(x);
        int start = 0;
        int end = s.length()-1;
        String result = "";
        if (s.charAt(0) == '-') {
            start = 1;
            result += "-";
        }
        while(end >= start) {
            result +=Character.toString(s.charAt(end--));
        }
        long resultLong = Long.parseLong(result);
        int finalResult =0;
        if (resultLong < 0) {
            finalResult = resultLong >= Integer.MIN_VALUE ? Integer.parseInt(result): 0;
        } else {
            finalResult = resultLong <= Integer.MAX_VALUE ? Integer.parseInt(result): 0;

        }

        return finalResult;
    }

    public static void main(String[] args) {
        int i = 1534236469;
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(i));

    }
}
