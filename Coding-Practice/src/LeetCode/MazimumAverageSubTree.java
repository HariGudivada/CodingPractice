package LeetCode;

/**
 * 1120
 */
public class MazimumAverageSubTree {
    public static double maximumAverageSubtree(TreeNode root) {
        if (root == null) {
            return 0.0;
        }

        if (root.left == null && root.right == null ) {
            return root.val/1;
        }

        double max = dfs(root, 0.0);

        return max;
    }

    private static double dfs(TreeNode root, double max) {
        if (root == null) {
            return max;
        }

        max = dfs(root.left, max);
        max = dfs(root.right, max);
        int sum = root.val;
        int count = 1;
        if (root.left != null) {
            count++;
            sum += root.left.val;
        }

        if (root.right != null) {
            count++;
            sum += root.right.val;
        }

        return sum/count > max ? sum/count : max;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.right = new TreeNode(1);
        maximumAverageSubtree(node);
    }
}
