public class SwapsRequired {
    public static void main(String[] args) {
        System.out.println(numOfSwaps("baaaa"));
        System.out.println(numOfSwaps("baaabbaabbba"));
        System.out.println(numOfSwaps("baabab"));
    }

    static int numOfSwaps(String S) {
        final int length = S.length();
        int consecutiveA = 0;
        int consecutiveB = 0;
        int swaps = 0;

        for (int i = 0; i < length; i++) {
            // Track consecutive same chars.
            if (S.charAt(i) == 'a') {
                consecutiveA++;
                consecutiveB = 0;
            } else {
                consecutiveB++;
                consecutiveA = 0;
            }

            // If same char has repeated 3 times then we need to swap.
            if (consecutiveA == 3) {
                consecutiveA = 0;
                swaps++;
            }

            if (consecutiveB == 3) {
                consecutiveB = 0;
                swaps++;
            }
        }
        //Time complexity: O(N) As we are iterating through the whole input once.
        //Space complexity: O(1) as we are not creating any additional inputs
        return swaps;
    }
}
