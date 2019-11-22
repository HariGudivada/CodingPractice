package LeetCode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class InvertBinaryTree {
    public InvertBinaryTree() {
    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        helper(root);

        if (root.left != null) {
            helper(root.left);
        }
        if (root.right != null) {
            helper(root.right);
        }

        return root;
    }

    private void helper(TreeNode root) {
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        invertBinaryTree.invertTree(root);
    }
}
