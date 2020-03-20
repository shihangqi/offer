/**
 * @Author shihangqi
 * @Date 2020/3/19 14:31
 * @Version 1.0
 */

/**
 * 旋转数组的最小数字
 *
 */
public class No11 {

    public static void main(String[] args) {
        int[] array = {1,0,1,1,1,1};

        System.out.println(process2(array));
    }

    //普通的
    public static Integer process(int [] array){
        if (array.length==0)return null;

        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]){
                return array[i+1];
            }
        }
        return array[0];

    }

    //二分法
    public static Integer process2(int[] array){

        if (array.length==0)return null;

        int low = 0;
        int high = array.length-1;
        int mid = 0;

        while (low<high){
            mid = (low + high)/2;
            if (array[mid] > array[high]) low = mid+1;
            else if (array[mid] < array[high]) high = mid;
            else {
                high--;
            }
        }

        return array[low];

    }



}
