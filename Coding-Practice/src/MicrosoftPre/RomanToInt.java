package MicrosoftPre;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    private static final Map<String, Integer> values = new HashMap<>();

    static {
        values.put("I", 1);
        values.put("IV", 4);
        values.put("V", 5);
        values.put("IX", 9);
        values.put("X", 10);
        values.put("XL", 40);
        values.put("L", 50);
        values.put("XC", 90);
        values.put("C", 100);
        values.put("CD", 400);
        values.put("D", 500);
        values.put("CM", 900);
        values.put("M", 1000);
    }
    public static int romanToInt(String s) {
        int ret = 0, len = 0;
        if (s == null || (len = s.length()) == 0) return ret;

        for (int i = 0; i < len; i++) {
            int val = values.get(String.valueOf(s.charAt(i)));
            if (i == len - 1) {
                ret += val;
            } else {
                String tmp = s.substring(i, i + 2);
                if (values.containsKey(tmp)) {
                    ret += values.get(tmp);
                    i++;
                } else ret += val;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        romanToInt("CMDXCIX");
    }
}
