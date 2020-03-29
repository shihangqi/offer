/**
 * @Author shihangqi
 * @Date 2020/3/28 14:34
 * @Version 1.0
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 链表中环的入口节点
 */
public class No23 {

    private class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode process(ListNode head){
        Set<ListNode> set = new HashSet<>();
        while (head!=null){
            if (!set.add(head)){
                return head;
            }
            head = head.next;
        }
        return null;
    }

}
