package chapter5;

/**
 * @Author shihangqi
 * @Date 2020/4/2 9:53
 * @Version 1.0
 */

import sun.applet.Main;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 数据流中的中位数
 */
public class No41 {

    //这里使用两个堆来实现，一个大顶堆，一个小顶堆，且要保证大顶堆的最大值小于小顶堆的最小值，
    //同时要保证两个堆的个数相差不超过1，（如果连个堆都没有元素则将第一个元素放入大顶堆，
    //则奇数个时直接取出小顶堆元素即为中位数。如果第一个放入小顶堆是相反。）

    private Queue<Integer> minPQ = new PriorityQueue<>();

    private Queue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());

    private int count = 0;

    public Integer solution(Integer num){
        if (count == 0){
            maxPQ.offer(num);
            count++;
            return maxPQ.peek();
        }
        else if ((count & 1) ==1){
            if (maxPQ.peek()>num){
                int temp = maxPQ.poll();
                maxPQ.offer(num);
                num = temp;
            }
            minPQ.offer(num);
            count++;
            return (maxPQ.peek()+minPQ.peek())/2;
        }else {
            if (minPQ.peek()<num){
                int temp = minPQ.poll();
                minPQ.offer(num);
                num = temp;
            }
            maxPQ.offer(num);
            count++;
            return maxPQ.peek();
        }


    }

    public static void main(String[] args) {
        No41 no41 = new No41();
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        while (num!=-1){
            num = scanner.nextInt();
            System.out.println(no41.solution(num));
        }
    }

}
