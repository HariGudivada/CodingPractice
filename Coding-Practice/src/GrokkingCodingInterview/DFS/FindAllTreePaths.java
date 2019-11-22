package GrokkingCodingInterview.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        if (root == null) {
            return Collections.emptyList();
        }
        
        dfs(root, sum, new ArrayList<>(), allPaths);
        return allPaths;
    }

    private static void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> allPaths) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(list));
            return;
        }
        dfs(root.left, sum-root.val, list, allPaths);
        dfs(root.right, sum-root.val, list, allPaths);
        //we need to remove curr node while going upwards. Backtracking.
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
