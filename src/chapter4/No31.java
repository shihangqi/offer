package chapter4;

/**
 * @Author shihangqi
 * @Date 2020/3/29 16:41
 * @Version 1.0
 */

import java.util.LinkedList;

/**
 * 栈的压入、弹出序列
 */
public class No31 {

  public boolean process(int[] push,int[] pop){

      if (push == null || pop == null|| push.length == 0 || pop.length == 0) return false;

      LinkedList<Integer> stack = new LinkedList<>();
      int i = 0;
      for (int p:push){
          stack.push(p);
          while (!stack.isEmpty()&&stack.peek()==pop[i]){
              stack.pop();
              i++;
          }
      }
      return stack.isEmpty();

  }
}
