package chapter4;

/**
 * @Author shihangqi
 * @Date 2020/3/29 14:13
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 顺时针打印矩阵
 */
public class No29 {

    public ArrayList<Integer> process(int[][] matrix){

        if(matrix ==null ||matrix.length==0)return null;

        ArrayList<Integer> list = new ArrayList<>();

        int left = 0;
        int top = 0;
        int rigth = matrix[0].length-1;
        int bottom = matrix.length-1;

        //需要满足一下条件
        //从左往右遍历的时，需要保证至少有一行
        //从上往下遍历时，需要保证至少有两行
        //从右往左遍历时，需要保证至少有两行，同时要有两列
        //从下往上遍历时，需要保证至少有三行两列
        while (left<=rigth && top<=bottom){
            //从左往右至少有一行
            for (int col = left;col<=rigth;col++) list.add(matrix[top][col]);
            //从上往下至少有两行
            if (top<bottom){
                for (int row = top+1;row<=bottom;row++) list.add(matrix[row][rigth]);
            }
            //从右往左至少两行两列
            if (top<bottom &&left<rigth){
                for (int col = rigth-1;col>=left;col++) list.add(matrix[bottom][col]);
            }
            //从下往上至少三行两列
            if (top<bottom-1 &&left<rigth){
                for (int row = bottom+1;row>=top;row++) list.add(matrix[row][left]);
            }
            left++;top++;rigth--;bottom--;
        }
        return list;
    }
}
