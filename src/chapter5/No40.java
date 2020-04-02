package chapter5;

/**
 * @Author shihangqi
 * @Date 2020/4/1 19:15
 * @Version 1.0
 */

import java.util.*;

/**
 * 最小的k个数
 */
public class No40 {


    public static void main(String[] args) {
        No40 no40 = new No40();
        int[] input = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(no40.process2(input, 4));
    }

    //使用最小堆实现，java自带有（小）大顶堆的结构，我觉得也不是不可以使用吧
    //这里
    public ArrayList<Integer> process2(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length == 0 || k < 0 || k > input.length) return list;

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        //这个是大顶堆实现方法。
        //PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i : input) {
            queue.offer(i);
            if (queue.size()>k) queue.poll();
        }

        list.addAll(queue);
        Collections.sort(list);
        return list;
    }
}
