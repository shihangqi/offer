/**
 * @Author shihangqi
 * @Date 2020/3/19 10:44
 * @Version 1.0
 */

/**
 * 二叉树的下一个节点
 */
public class No08 {

    private class TreeNode{

        private int data;
        private TreeNode parentsNode;
        private TreeNode LchaildNode;
        private TreeNode RchaildNode;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public TreeNode process(TreeNode node){

        if (node.RchaildNode!=null){
            while (node.LchaildNode!=null){
                node = node.LchaildNode;
            }
            return node;
        }

        while (node.parentsNode!=null && node.parentsNode.LchaildNode == node){
            node = node.parentsNode;
        }

        return node;
    }



}
