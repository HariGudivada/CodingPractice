package LeetCode;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int l = 0;
        int r = s.length()-1;

        while (l <= r) {
            while (!Character.isLetter(s.charAt(l))) {
                l++;
            }
            while (!Character.isLetter(s.charAt(r))) {
                r--;
            }
            Character lc = s.charAt(l);


            if (Character.isUpperCase(lc)) {
                lc = Character.toLowerCase(lc);
            }

            Character rc = s.charAt(r);


            if (Character.isUpperCase(rc)) {
                rc = Character.toLowerCase(rc);
            }

            if (lc != rc) {
                return false;
            }
            l++;
            r--;
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println("isPalindrome : "+ isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println('a' == 'A');
    }
}
