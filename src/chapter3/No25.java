package chapter3; /**
 * @Author shihangqi
 * @Date 2020/3/28 15:41
 * @Version 1.0
 */


import java.util.*;

/**
 * 合并两个排序链表
 */
public class No25 {
    private static class ListNode{
        int data;
        ListNode next;
    }

    public ListNode process(ListNode list1, ListNode list2){
        if (list1==null) return list2;
        if (list2==null) return list1;

        ListNode newlist;

        if (list1.data<list2.data){
            newlist = list1;
            list1 = list1.next;
        }else {
            newlist = list2;
            list2 = list2.next;
        }

        ListNode cur = newlist;

        while (list1 != null && list2 != null){
            if (list1.data<list2.data){
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 == null){
            newlist.next = list2;
        }
        if (list2 == null){
            newlist.next = list1;
        }

        return newlist;
    }


    public static void main(String[] args) {
        No25 no25 = new No25();
        ListNode[] listNodes = new ListNode[10];
        Random random = new Random();
        //生成随机数的递增ListNode[]
        for (int i = 0; i < listNodes.length; i++) {
            ListNode head = new ListNode();
            ListNode current = head;
            for (int j = 0; j < random.nextInt(15)+1; j++) {
                ListNode node = new ListNode();
                node.data = (j+1)*(i+1);
                node.next = null;
                current.next = node;
                current = current.next;
                System.out.print(node.data+" ");
            }
            listNodes[i] = head.next;
            System.out.println();
        }

        System.out.println("========================");
        ListNode listNode = no25.process2(listNodes);
        while (listNode!=null){
            System.out.print(listNode.data+" ");
            listNode = listNode.next;
        }
    }
    
    
    
    /**
     * 合并N个排序链表
     */
    public ListNode process2(ListNode[] listNodes){

        if(listNodes == null || listNodes.length==0) return null;

        ListNode newList = new ListNode();

        ListNode current = newList;

        //底层是一个小顶堆  比较
        Queue<ListNode> queue = new PriorityQueue<ListNode>(listNodes.length,new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.data - o2.data;
            }
        });

        for (ListNode node:listNodes) {
            if (node!=null){
                queue.offer(node);
            }
        }
        while (!queue.isEmpty()){
            ListNode temp = queue.poll();
            current.next = temp;
            if (temp.next!=null){
                queue.offer(temp.next);
            }
            current = current.next;
        }
        return newList.next;
    }


}
