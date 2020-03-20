/**
 * @Author shihangqi
 * @Date 2020/3/19 11:25
 * @Version 1.0
 */

/**
 * 斐波那契数列
 *       {0   n=0}
 * f(n)= {1   n=1}
 *       {f(n-1)+f(n-2) n>1}
 */
public class No10 {

    public static void main(String[] args) {
        System.out.println(process2(10));
    }


    //首先是递归实现
    public static Integer process(Integer n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        return process(n-1)+process(n-2);
    }

    //非递归
    public static Integer process2(Integer n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }

        Integer n0 = 0;
        Integer n1 = 1;
        Integer result = 0;

        for (int i = 1; i < n; i++) {
            result = n1 + n0;
            n0 = n1;
            n1 = result;
        }
        return result;

    }

    //青蛙跳台阶问题
    public static Integer process3(Integer n){
        if (n<=0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }

        Integer n0 = 1;
        Integer n1 = 2;
        Integer result = 0;

        for (int i = 1; i < n; i++) {
            result = n1 + n0;
            n0 = n1;
            n1 = result;
        }
        return result;


    }



}
