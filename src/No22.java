/**
 * @Author shihangqi
 * @Date 2020/3/28 11:25
 * @Version 1.0
 */

/**
 * 链表中倒数第K个节点
 */
public class No22 {

    private class ListNode{
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode process(ListNode head,int k){

        if (k<0 || head==null){
            return null;
        }

        ListNode a = head;
        ListNode b = head;

        for (int i = 0; i < k - 1; i++) {
            if (a.next == null){
                return null;
            }
        }
        while (a.next!=null){
            a = a.next;
            b = b.next;
        }
        return b;
    }

}
