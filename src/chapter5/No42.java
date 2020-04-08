package chapter5;

/**
 * @Author shihangqi
 * @Date 2020/4/2 11:16
 * @Version 1.0
 */

/**
 * 连续子数组的最大和
 */
public class No42 {

    public int solution(int[] array){

        if (array==null || array.length == 0 ) return 0;

        int curSum = array[0];
        int maxSum = array[0];

        for (int item : array) {
            if (curSum<0) curSum = item;
            else curSum+=item;
            if (curSum > maxSum) maxSum = curSum;
        }
        return maxSum;
        String s =new String();
        s.toCharArray();
    }

}
