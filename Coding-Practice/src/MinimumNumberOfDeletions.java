import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//Mininum number of deletion sto make all the character appear unique number of times.
public class MinimumNumberOfDeletions {

    public  static int solution(String S) {
        if(S == null || S.isEmpty()) {
            return 0;
        }
        //Map to hold the count for each character in the string.
        final Map<Character, Integer> charToIntegerMap = new HashMap<>();
        for ( final char c : S.toCharArray()) {
            //If we dont have the character as the key we place it in the map and with count zero as its value
            // and the increment to 1 in the next step.If we already have the character we just increment it count.
            charToIntegerMap.computeIfAbsent(c, f -> 0);
            int count = charToIntegerMap.get(c);
            charToIntegerMap.put (c, ++count);
        }



        //As we want each letter to appear unique number of times, we store the count for all the characters in the set
        // and decrement if we see a count that has already been in the set until the count was not in the set.
        final Set<Integer> set = new HashSet<>();
        int requiredCount = 0;
        for (int value : charToIntegerMap.values()) {
            //Check if the character count is in the set and decrement the count by 1 and check
            // again and repeat the process until we see a unique value or count is 0
            while (set.contains(value) && value > 0) {
                value--;
                requiredCount++;
            }

            set.add(value);
        }

        return requiredCount;
    }

    //The time complexity of this algorithm would be O(N) where N is the number of characters in the string, as we are iterating through input.
    //The space complexity will be O(N) as we are using separate storage for counts.

    public static void main(String[] args) {
        System.out.println(solution("abbcccddddeeeeeffffffghijklmnopqrstuvwxyz"));
    }
}
