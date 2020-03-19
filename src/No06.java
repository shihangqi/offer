/**
 * @Author shihangqi
 * @Date 2020/3/19 9:33
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头打印链表
 */
public class No06 {

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        process2(node);
    }


    public static void process(ListNode  listNode){

        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (ListNode node = listNode; node != null; node = node.next) {
            stack.push(node.val);
        }
        System.out.println(stack);
    }


    public static void process2(ListNode listNode){

        if (listNode==null){
            return;
        }
        process2(listNode.next);
        System.out.println(listNode.val);
    }
}
