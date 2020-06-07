package leetcode.tree;

public class TreeBuilder {

    public static TreeNode buildTreeNode(String parameter) {
        parameter = parameter.substring(1, parameter.length() - 1);
        String[] split = parameter.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(split[0]));
        dfsBuildTreeNode(split, root, 0);
        return root;
    }

    private static void dfsBuildTreeNode(String[] split, TreeNode parent, int index) {
        if (index >= split.length) {
            return;
        }
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        if (leftIndex < split.length) {
            String tmp = split[leftIndex];
            if (!"null".equals(tmp)) {
                parent.left = new TreeNode(Integer.valueOf(tmp));
                dfsBuildTreeNode(split, parent.left, leftIndex);
            }
        }
        if (rightIndex < split.length) {
            String tmp = split[rightIndex];
            if (!"null".equals(tmp)) {
                parent.right = new TreeNode(Integer.valueOf(tmp));
                dfsBuildTreeNode(split, parent.right, rightIndex);
            }
        }
    }

}
