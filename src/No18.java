/**
 * @Author shihangqi
 * @Date 2020/3/20 16:45
 * @Version 1.0
 */

/**
 * 删除链表的节点
 */
public class No18 {

    static class LinkNode{
        int data;
        LinkNode next;
    }

    public static void process(LinkNode head,LinkNode deleteNode){
        if (head == null || deleteNode == null)
            return;
        if (head == deleteNode)
            head = head.next;
        else if(deleteNode.next != null){
            deleteNode.data = deleteNode.next.data;
            deleteNode.next = deleteNode.next.next;
        }
        else {//删除为节点时
            LinkNode node = head;
            while (node.next!=deleteNode){
                node = node.next;
            }
            node.next = null;
        }

    }


    //删除链表中重复节点

    public static void deleteNode(LinkNode head){
        LinkNode first = new LinkNode();
        first.next = head;

        LinkNode p = first;
        LinkNode q = first.next;
        while (p.next!=null){
            int count = 0;
            while (q!=null && q.data==p.next.data){
                q = q.next;
                count++;
            }
            if (count>1){
                p.next = q;
            }else {
                p = p.next;
            }
        }

    }
}
