public class AnagramProblem {

    public static int countNeeded (String first, String second) {
        int[] firstCount = getCharCount(first);
        int[] secondCount = getCharCount(second);

        return getDelta(firstCount, secondCount);
    }

    private static int getDelta(final int[] firstCount, final int[] secondCount) {
        int delta = 0;
        //exception if both arrays doesn't have same length.

        for (int i = 0 ; i < firstCount.length; i++) {
            delta +=  Math.abs(firstCount[i] - secondCount[i]);
        }

        return delta;
    }


    private static int[] getCharCount(final String first) {
        //verify exception if string is null , empty or blank;
        final int[] charCount = new int[26];
        final int offset = (int) 'a';
        for (int i=0; i< first.length(); i++) {
            int c = first.charAt(i);
            charCount[c-offset]++;
        }

        return charCount;
    }

    public static void main(String[] args) {
        System.out.println(countNeeded("hello", "billion"));//ans should be 6;
    }
}
