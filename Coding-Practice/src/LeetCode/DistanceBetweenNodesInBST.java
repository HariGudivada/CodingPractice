package LeetCode;

/**
 * https://leetcode.com/discuss/interview-question/376375
 */
public class DistanceBetweenNodesInBST {
    public static int distanceBetweenNodes(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = LCA(root, p, q);
        int leftDistance = 0;
        int rightDistance = 0;
        TreeNode temp = lca;
        while(temp != p) {
            if (p.val < temp.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
            leftDistance++;
        }
        temp = lca;
        while(temp != q) {
            if (q.val > temp.val) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
            rightDistance++;
        }

        return leftDistance+rightDistance;
    }

    private static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val && q.val < root.val) {
            return LCA(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return LCA(root.right, p, q);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        System.out.println(distanceBetweenNodes(root, root.left.right , root.left.right.left));
    }
}
