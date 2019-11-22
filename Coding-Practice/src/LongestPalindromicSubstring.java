public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        int l = 0;
        int r = s.length()-1;
        return getLongest(l, r, s);

    }

    private String getLongest(int l, int r, String s) {
        String a = null;
        String b = null;
        while(l<=r){
            if(s.charAt(l) != s.charAt(r)) {
               a = getLongest(l+1, r, s);
                b =getLongest(l, r-1, s);
            }
            l+=1;
            r-=1;
        }
        if(a != null && b!= null) {
            return Math.max(a.length(), b.length()) == a.length()? a : b;
        }
        return s;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        l.longestPalindrome("baba");
    }
}
