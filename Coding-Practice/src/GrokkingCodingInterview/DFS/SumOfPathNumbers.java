package GrokkingCodingInterview.DFS;

public class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int result = dfs(root, "", 0);
        return result;
    }

    private static int dfs(TreeNode root, String sum, int result) {
        if (root == null) {
            return result;
        }
        sum += root.val;
        int leftVal = 0, rightVal = 0;
        if (root.left == null && root.right == null) {
            result += Integer.parseInt(sum);
        } else {
            leftVal += dfs(root.left, sum, result);
            rightVal += dfs(root.right, sum, result);
        }
        result += (leftVal+rightVal);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
