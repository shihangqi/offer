package chapter5;
import java.util.concurrent.Executor;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author shihangqi
 * @Date 2020/4/9 19:04
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {

    }
    public int process(int[] array){
        if(array == null || array.length ==0)return -1;

        /*if(array.length);*/

        int low = 0;
        int high = array.length-1;

        while(low<high){
            int mid = (low+high)/2;
            if(array[mid] > array[mid-1] && array[mid] > array[mid+1]){
                return array[mid];
            }else if(array[mid] > array[mid-1] && array[mid] < array[mid+1]){
                low = mid+1;
            }else if(array[mid] < array[mid-1] && array[mid] > array[mid+1]){
                high = mid-1;
            }
        }

        return -1;

    }

}
