/**
 * @Author shihangqi
 * @Date 2020/3/28 10:31
 * @Version 1.0
 */

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class No21 {


    public static void main(String[] args) {
        No21 no21 = new No21();
        int[] a = {3, 2, 1, 9, 8, 7, 4, 5, 6};
        no21.process(a);
        System.out.println(Arrays.toString(a));
    }

    public void process(int[] array){
        if (array==null){
            return ;
        }
        int high = array.length-1;
        for (int i = 0; i < high; i++) {
            if ((array[i] & 1) == 0){
                int temp = array[high];
                array[high] = array[i];
                array[i] = temp;
                i--;
                high--;
            }
        }
    }


}
