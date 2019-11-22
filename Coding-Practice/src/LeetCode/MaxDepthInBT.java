package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthInBT {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int currDepth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                if (n.left != null) {
                    q.offer(n.left);
                }

                if (n.right != null) {
                    q.offer(n.right);
                }
            }

            currDepth++;
        }

        return currDepth-1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(4);
        treeNode.left.left = new TreeNode(1);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(-1);
        treeNode.left.left.left = new TreeNode(5);
        treeNode.left.left.right = new TreeNode(1);
        treeNode.right.left.left = new TreeNode(6);
        treeNode.right.right.left = new TreeNode(8);
        maxDepth(treeNode);
    }
}
