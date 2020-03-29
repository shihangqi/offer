package chapter2; /**
 * @Author shihangqi
 * @Date 2020/3/19 15:26
 * @Version 1.0
 */


/**
 * 矩阵中的路径
 */
public class No12 {


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        if (matrix == null || rows <= 0|| cols <=0 || str == null) return false;

        boolean[] marked = new boolean[matrix.length];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (process(matrix,rows,cols,i,j,str,0,marked)){
                    return true;
                }
            }

        }

        return false;
    }



    public static boolean process(char[] matrix, int rows, int cols, int row, int col, char[] str, int len, boolean[] marked){

        //由于用一维数组表示二维矩阵，第row行第col列，就是row*cols+col
        int index = row*cols+col;
        if (row < 0 || row >= rows || col < 0 || col >= cols || matrix[index] != str[len] || marked[index]) {
            return false;
        }

        if (len == str.length-1){
            return true;
        }

        marked[index] = true;


        if (process(matrix,rows,cols,row-1,col,str,len+1,marked)||
            process(matrix,rows,cols,row+1,col,str,len+1,marked)||
            process(matrix,rows,cols,row,col-1,str,len+1,marked)||
            process(matrix,rows,cols,row,col+1,str,len+1,marked))
            return true;
        marked[index] = false;
        return false;

    }
}
