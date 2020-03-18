/**
 * @Author shihangqi
 * @Date 2020/3/18 16:09
 * @Version 1.0
 */

/**
 * 二维数组中的查找
 */

public class No04 {



    public static void main(String[] args) {

        int[][] matrix ={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};

        System.out.println(process(matrix, 4, 4, 7));
    }


    public static boolean process(int[][] matrix,int rows,int columns,int number){

        if (matrix==null || rows<0 || columns<0){
            return false;
        }
        int row = 0;
        int column = columns-1;
        while ( column >= 0&& row < rows) {

            if (matrix[row][column] == number){
                return true;
            }
            else if (matrix[row][column] > number){
                column--;
            }
            else
                row++;
        }
        return false;
    }


}
