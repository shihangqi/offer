package chapter4;

/**
 * @Author shihangqi
 * @Date 2020/3/29 15:40
 * @Version 1.0
 */

import java.util.LinkedList;

/**
 * 包含min函数的栈
 */
public class No30 {

    private LinkedList<Integer> stack = new LinkedList<>();

    private LinkedList<Integer> minStack = new LinkedList<>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x < minStack.peek()){
            minStack.push(x);
        }else {
            minStack.push(minStack.peek());
        }

    }

    public void pop() {
        if (stack.isEmpty()){
            throw new RuntimeException("stack is empty!");
        }
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()){
            throw new RuntimeException("stack is empty!");
        }
        return stack.peek();
    }

    public int min() {
        if (minStack.isEmpty()){
            throw new RuntimeException("stack is empty!");
        }
        return minStack.peek();
    }

    //peek()是不删除，只看一下第一个。等于stack中的top();
    //pop是弹出第一个值。
}
