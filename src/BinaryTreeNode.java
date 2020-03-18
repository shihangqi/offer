public class BinaryTreeNode {
    private int data;
    private BinaryTreeNode LchaildNode;
    private BinaryTreeNode RchaildNode;

    public BinaryTreeNode(int data){
        super();
        this.data = data;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLchaildNode() {
        return LchaildNode;
    }

    public void setLchaildNode(BinaryTreeNode lchaildNode) {
        LchaildNode = lchaildNode;
    }

    public BinaryTreeNode getRchaildNode() {
        return RchaildNode;
    }

    public void setRchaildNode(BinaryTreeNode rchaildNode) {
        RchaildNode = rchaildNode;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "data=" + data +
                ", LchaildNode=" + LchaildNode +
                ", RchaildNode=" + RchaildNode +
                '}';
    }
}
