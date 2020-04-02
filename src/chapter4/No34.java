package chapter4;

/**
 * @Author shihangqi
 * @Date 2020/3/31 19:32
 * @Version 1.0
 */

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 */
public class No34 {

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> process(TreeNode root, int num){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null||num<root.val) return list;
        ArrayList<Integer> path = new ArrayList<>();
        preOrder(root, num, path, list);
        return list;

    }

    private void preOrder(TreeNode root, int num, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> list) {
        if (root == null) return;

        path.add(root.val);
        num -=root.val;
        if (root.left==null &&root.right==null){
            if (num == 0) list.add(new ArrayList<>(path));
        }

        preOrder(root.left,num,path,list);
        preOrder(root.right,num,path,list);

        path.remove(path.size());
        num+=root.val;
    }

}
