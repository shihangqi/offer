package chapter4;

/**
 * @Author shihangqi
 * @Date 2020/4/1 12:55
 * @Version 1.0
 */

/**
 * 二叉搜索树与双向链表
 *
 */
public class No36 {

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;


        public TreeNode(int val) {
            this.val = val;
        }
    }
//首先是中序线索化二叉树的流程
    private TreeNode pre = null;

    public void process(TreeNode root){
        if (root == null) return ;
        //遍历左支
        process(root.left);

        if (root.left==null){
            root.left = pre;
        }

        if (pre!=null&&pre.right==null){
            pre.right=root;
        }
        pre = root;
        //遍历右支
        process(root.right);
    }

//这里是将二叉搜索树转换成双向链表
    public TreeNode process2(TreeNode node){
       if (node == null) return null;

       TreeNode temp = node;

        process3(node);
        while (temp.left!=null){
            temp=temp.left;
        }
        return temp;
    }

    private TreeNode process3(TreeNode node){
        if (node == null) return null;
        //遍历左支
        process(node.left);

        node.left = pre;

        if (pre!=null){
            pre.right=node;
        }
        pre = node;
        //遍历右支
        process(node.right);
        return node;
    }
}
