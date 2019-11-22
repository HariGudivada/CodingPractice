package MicrosoftPre;

import java.util.HashSet;
import java.util.Set;

//202
public class HappyNumber {
    public boolean happyNumber(int n) {
        Set<Integer> set = new HashSet<>();
        String ns = Integer.toString(n);

        while (Integer.parseInt(ns) >0) {

            if (ns.equals("1")) {
                return true;
            }
            int i = 0, sum =0;
            while (i < ns.length()) {
                int k = ns.charAt(i) - '0';
                k = k * k;
                sum += k;
                i++;
            }
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            ns = Integer.toString(sum);
        }
        return false;
    }

    public int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n%10;
            n = n/10;
            sum += d*d;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && ! seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }

        return n == 1;
    }



    public static void main(String[] args) {
        int n = 19;
        HappyNumber happyNumber = new HappyNumber();
        happyNumber.isHappy(n);
    }
}
