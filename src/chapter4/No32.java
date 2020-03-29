package chapter4;

/**
 * @Author shihangqi
 * @Date 2020/3/29 17:14
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 从上到下打印二叉树
 */
public class No32 {

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> process(TreeNode root){
        if (root == null) return null;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            arrayList.add(temp.val);
            if (temp.left!=null) queue.push(temp.left);
            if (temp.right!=null) queue.push(temp.right);
        }
        return arrayList;
    }

}
