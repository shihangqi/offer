package chapter4;

/**
 * @Author shihangqi
 * @Date 2020/3/29 10:56
 * @Version 1.0
 */


import java.util.LinkedList;

/**
 * 二叉树的镜像
 */
public class No27 {

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //递归法
    public void process(TreeNode root){
        if(root == null) return ;
        if (root.left==null&&root.right==null)return ;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        process(root.left);
        process(root.right);

    }
    /**
     * 非递归，前序遍历
     */
    public void mirror_preOrder(TreeNode root) {
        //因为linkedList采用的是头插法所以相当于一个栈，也有先进后出的效果。使用push进行头插法。add是尾插法
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 当前结点不为空，或者为空但有可以返回的父结点（可以进行pop操作）都可以进入循环
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                // 交换两个子结点
                if (root.left != null || root.right != null) {
                    TreeNode temp = root.left;
                    root.left = root.right;
                    root.right = temp;
                }
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }



}
