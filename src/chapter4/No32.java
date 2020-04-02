package chapter4;

/**
 * @Author shihangqi
 * @Date 2020/3/29 17:14
 * @Version 1.0
 */

import java.util.*;

/**
 * 从上到下打印二叉树
 */
public class No32 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
            if (temp.left!=null) queue.offer(temp.left);
            if (temp.right!=null) queue.offer(temp.right);
        }
        return arrayList;
    }

    //分行从上到下打印二叉树
    public void process2(TreeNode root){
        if (root == null) return ;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 下一层的结点数
        int nextLevel = 0;
        // 本层还有多少结点未打印,因为目前只有根结点没被打印所以初始化为1
        int toBePrinted = 1;

        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.val+" ");
            toBePrinted--;

            if (temp.left!=null){
                queue.offer(temp.left);
                nextLevel++;
            }
            if (temp.right!=null){
                queue.offer(temp.right);
                nextLevel++;
            }
            if (toBePrinted == 0){
                System.out.println();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
    }

    //之字形从上到下打印二叉树
    //这里使用的是一个双端队列，可以从两端进行进出值
    public List<List<Integer>> process3(TreeNode root){
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;

        while (!queue.isEmpty()){
            int layerSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < layerSize; i++) {
                TreeNode temp;
                if ((level&1)==1){
                    temp = queue.poll();
                    System.out.println("left:"+temp.left);
                    System.out.println("right:"+temp.right);
                    if (temp.left != null) queue.offer(temp.left);
                    if (temp.right != null) queue.offer(temp.right);
                }else {
                    temp = queue.pollLast();
                    System.out.println("left:"+temp.left);
                    System.out.println("right:"+temp.right);
                    if (temp.left != null) queue.push(temp.right);
                    if (temp.right != null) queue.push(temp.left);
                }
                list.add(temp.val);
            }
            level++;
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        No32 no32 = new No32();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.left = treeNode2;
        System.out.println(no32.process3(treeNode1));
    }

}
