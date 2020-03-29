package chapter2; /**
 * @Author shihangqi
 * @Date 2020/3/19 9:58
 * @Version 1.0
 */


/**
 * 重建二叉树
 */
public class No07 {

    public static void main(String[] args) {

        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};

        BinaryTreeNode node =  process(pre,0,pre.length-1,in,0,in.length-1);

        print(node);

    }

    public static void print(BinaryTreeNode node){
        if (node ==null){
            return;
        }

        System.out.println(node.getData());
        print(node.getLchaildNode());
        print(node.getRchaildNode());


    }


    public static BinaryTreeNode process(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
        if (preStart>preEnd || inStart>inEnd)
            return null;
        BinaryTreeNode treeNode = new BinaryTreeNode(pre[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]){
                treeNode.setLchaildNode(process(pre,preStart+1,preStart+1+i-1-inStart,in,inStart,i-1));
                treeNode.setRchaildNode(process(pre,preStart+i-inStart+1,preEnd,in,i+1,inEnd));
            }
        }
        return treeNode;
    }
}
