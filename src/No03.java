/**
 * @Author shihangqi
 * @Date 2020/3/18 15:33
 * @Version 1.0
 */


import sun.security.util.Length;

import java.util.Arrays;

/**
 * 找出数组中重复的数组
 */

public class No03 {

    public static void main(String[] args) {
        int [] numbers = {2,3,1,0,2,5,3};
        int [] numbers2 = {2,3,1,0,2,5,3};

        System.out.println(process(numbers,numbers.length));
        System.out.println(process2(numbers2,numbers2.length));

    }

    public static int process(int numbers[],int length){

        if (numbers==null || length==0){
            return -1;
        }

        for (int i = 0; i < length; i++) {
            if (numbers[i]<0 ||numbers[i]>length-1) return -1;
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length-1; i++) {
            if (numbers[i]==numbers[i+1]){
                return numbers[i];
            }
        }
        return -1;
    }

    /**
     *
     * 这个是第二个交换位置的方法
     *
     * @param numbers
     * @param length
     * @return
     */

    public static int process2(int numbers[],int length){

        if (numbers==null || length==0){
            return -1;
        }

        for (int i = 0; i < length; i++) {
            if (numbers[i]<0 ||numbers[i]>length-1) return -1;
        }

        for (int i = 0; i < length; i++) {
            while (numbers[i]!=i){
                if (numbers[i] == numbers[numbers[i]]) return numbers[i];
                else {
                    int temp = numbers[numbers[i]];
                    numbers[numbers[i]] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        return -1;
    }


}
