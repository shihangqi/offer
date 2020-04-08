package chapter4;

/**
 * @Author shihangqi
 * @Date 2020/4/1 13:31
 * @Version 1.0
 */

import sun.nio.ch.ThreadPool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 序列化二叉树
 */
public class No37 {

    private class TreeNode {

        int data;
        TreeNode lchild;
        TreeNode rchild;

        TreeNode(int data){
            this.data = data;
        }

    }

    public String process(TreeNode root){

        if (root == null) return null;
        StringBuilder stringBuilder = new StringBuilder();
        preOrder(root,stringBuilder);
        return stringBuilder.toString();
    }

    private void preOrder(TreeNode node,StringBuilder sb){
        if (node == null) {
            sb.append("# ");
            return ;
        }
        sb.append(node.data).append(" ");
        preOrder(node.lchild,sb);
        preOrder(node.rchild,sb);
    }



    //反序列化
    private int index = 0;

    public TreeNode process2(String s){
        if (s == null) return null;

        String[] strings = s.split(" ");

        return reconstructBST(strings);
    }

    private TreeNode reconstructBST(String[] s){
        if (s[index].equals("#")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(s[index++]));
        node.lchild = reconstructBST(s);
        node.rchild = reconstructBST(s);

        return node;

    }

}
