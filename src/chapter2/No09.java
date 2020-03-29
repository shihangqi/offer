package chapter2; /**
 * @Author shihangqi
 * @Date 2020/3/19 11:04
 * @Version 1.0
 */

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class No09 {

    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();


    public static void main(String[] args) {
        appendTail(1);
        appendTail(2);
        appendTail(3);
        System.out.println(deleteHead());
        System.out.println(deleteHead());
        appendTail(4);
        System.out.println(deleteHead());
        System.out.println(deleteHead());
    }


    public static boolean appendTail(Integer number) {
        stack1.push(number);
        return true;
    }

    public static Integer deleteHead() {

        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        } else
            return null;


    }

}
