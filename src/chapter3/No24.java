package chapter3; /**
 * @Author shihangqi
 * @Date 2020/3/28 15:19
 * @Version 1.0
 */


import java.util.List;

/**
 * 反转链表
 */
public class No24 {

    private class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data = data;
        }
    }


    public ListNode process(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode pre = null;
        ListNode next = null;
        ListNode current = head;
        while (current!=null){

            next = current.next;

            current.next = pre;

            pre = current;

            current = next;
        }
        return pre;
    }

//   递归调用方法，说实话没太明白。。。
    public ListNode process2(ListNode head){
        if (head == null || head.next == null)return head;

        ListNode revHead = process2(head.next);
        ListNode nextNode = head.next;
        nextNode.next = head;
        head.next = null;
        return revHead;

    }

}
