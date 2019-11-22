import java.util.Stack;

public class BalancedParantheses {

    private static final char[][] prantheses = {{'{', '}'}, {'(', ')'}, {'[', ']'}};

    public static boolean isBalancedPranatheses(String input) {

        Stack<Character> stack = new Stack<Character>();

        for(char c : input.toCharArray()) {
            if (isOpenBracket(c)) {
                stack.push(c);
            }
            else {
                if (stack.isEmpty() || !matches(stack.pop(), c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean matches(final char openingBracket, final Character closeingBracket) {
        for (char[] array : prantheses) {
            if (array[0] == openingBracket) {
                return array[1] == closeingBracket;
            }
        }

        return false;
    }

    private static boolean isOpenBracket(final char openingBracket) {
        for (char[] array : prantheses) {
            if (array[0] == openingBracket) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isBalancedPranatheses("{[](){{{}}}}"));
    }
}
