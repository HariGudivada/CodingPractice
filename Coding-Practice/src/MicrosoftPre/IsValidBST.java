package MicrosoftPre;
//98 https://leetcode.com/problems/validate-binary-search-tree/
public class IsValidBST {
    public static boolean isValidBst(ZigZagTraversalBT.TreeNode root) {
        if (root == null) {
            return true;
        }
        if(root.left != null && root.left.val > root.val || root.right!= null && root.right.val < root.val) {
            return false;
        }

        return isValidBst(root.left, Integer.MIN_VALUE, root.val) && isValidBst(root.right, root.val, Integer.MAX_VALUE);
    }

    private static boolean isValidBst(ZigZagTraversalBT.TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.val > min || root.val < max) {
            return true;
        }

        return isValidBst(root.left, min, root.val) && isValidBst(root.right, root.val, max);
    }

    public static void main(String[] args) {
        ZigZagTraversalBT.TreeNode root = new ZigZagTraversalBT.TreeNode(4);
        root.left = new ZigZagTraversalBT.TreeNode(2);
        root.right = new ZigZagTraversalBT.TreeNode(5);
        root.left.left = new ZigZagTraversalBT.TreeNode(1);
        root.left.right = new ZigZagTraversalBT.TreeNode(3);
        isValidBst(root);
    }
}
