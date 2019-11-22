package MicrosoftPre;

        import java.util.*;

public class ZigZagTraversalBT {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            result.add(list);
            int level_length = queue.size();
            if (level % 2 == 1) { //left to right
                for (int i = 0; i < level_length; i++) {
                    TreeNode curr = queue.pollFirst();
                    result.get(level).add(curr.val);//adding to child list.
                    if (curr.right != null) {
                        queue.addLast(curr.right);
                    }

                    if (curr.left != null) {
                        queue.addLast(curr.left);
                    }
                }
            } else {
                for (int i = 0; i < level_length; i++) {
                    TreeNode curr = queue.pollLast();
                    result.get(level).add(curr.val);//adding to child list.
                    if (curr.left != null) {
                        queue.offerFirst(curr.left);
                    }

                    if (curr.right != null) {
                        queue.offerFirst(curr.right);
                    }
                }
            }
            level++;
        }
        return result;
    }

    public void helper(TreeNode root, int level, boolean fromLeft) {
        if (result.size() == level) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }


        if (fromLeft) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            list.addAll(result.get(level));
            result.set(level, list);
            if (root.left != null) {
                helper(root.left, level + 1, false);
            }

            if (root.right != null) {
                helper(root.right, level + 1, false);
            }
        } else {
            result.get(level).add(root.val);

            if (root.right != null) {
                helper(root.right, level + 1, true);
            }

            if (root.left != null) {
                helper(root.left, level + 1, true);
            }

        }

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return true; //TODO implement this later.
    }

    public boolean hasPath(TreeNode root, int sum, int currSum) {
        if ( root == null) {
            return false;
        }
        currSum = currSum + root.val;
        if (sum == currSum) {
            return true;
        }
        return hasPath(root.left, sum, currSum) || hasPath(root.right, sum, currSum);
    }
}
