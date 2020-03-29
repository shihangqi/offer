package chapter4;

/**
 * @Author shihangqi
 * @Date 2020/3/29 13:53
 * @Version 1.0
 */

import sun.reflect.generics.tree.Tree;

/**
 * 对称的二叉树
 */
public class No28 {

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean process(TreeNode root){
        if (root == null) return true;
        return isSymmetrical(root.left, root.right);
    }

    private boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1==null && root2==null)return true;
        if (root1==null || root2==null)return false;
        if (root1.val != root2.val) return false;

        return isSymmetrical(root1.left,root2.right) && isSymmetrical(root1.right,root2.left);
    }
}
