/**
 * @Author shihangqi
 * @Date 2020/3/19 20:10
 * @Version 1.0
 */

import sun.security.util.Length;

/**
 * 剪绳子
 */
public class No14 {


    public static void main(String[] args) {
        System.out.println(process2(10));
    }


    public static int process(int n){
        if (n<4)return n-1;

        int[] products = new int[n+1];
        // 下面这三个存的不是f(1)、f(2)、f(3)，只是单纯的长度而已
        // 这里为什么这么写，因为提议中说切的m段必须是大于1的所以之前返回的时候3为切成1和2，
        // 乘积为2，但实际上1*2小于3所以这里3的max应该是不切一次
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i/2; j++) {
                int product = products[j] * products[i-j];
                if (product>max)
                    max = product;
            }
            products[i] = max;
        }
        return products[n];

    }



    //方法二贪心算法，这个是基于数学定理的过程
    public static int process2(int n) {
        if (n<4) return n-1;

        int timesOf3 = n/3;

        if (n%3 == 1){
            timesOf3 --;
        }
        int timesOf2 = (n-timesOf3*3)/2;

        return (int)Math.pow(3,timesOf3)*(int)Math.pow(2,timesOf2);

    }
}
