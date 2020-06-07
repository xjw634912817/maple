package leetcode.tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode mirror = new TreeNode(root.val);
        dfs(root, mirror);
        return mirror;
    }

    private void dfs(TreeNode root, TreeNode mirror) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            mirror.left = new TreeNode(root.right.val);
            dfs(root.right, mirror.left);
        }
        if (root.left != null) {
            mirror.right = new TreeNode(root.left.val);
            dfs(root.left, mirror.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTreeNode("1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5");

    }


}