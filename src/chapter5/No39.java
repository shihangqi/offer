package chapter5;

/**
 * @Author shihangqi
 * @Date 2020/4/1 18:29
 * @Version 1.0
 */

/**
 * 数组中出现次数超过一半的数字
 */
public class No39 {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,2,2,2,5,4,2};
        No39 no39 = new No39();
        System.out.println(no39.process(array));
    }


    public int process(int[] array){

        int result = array[0];
        int num = 0;

        for (int value : array) {
            if (num == 0) {
                result = value;
            }
            if (value == result) num++;
            else {
                num--;
            }

        }

        return check(array,result);
    }

    private int check(int[] array, int result) {

        int count = 0;
        for (int value : array) {
            if (value == result) count++;
        }
        return count>=array.length/2 ? result : 0;

    }

}
