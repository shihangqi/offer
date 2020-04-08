/**
 * @Author shihangqi
 * @Date 2020/4/2 8:52
 * @Version 1.0
 */

import javax.xml.crypto.Data;
import java.util.Scanner;

/**
 * 给出一个数n，求两个数a，b（1<=a,b<=n），使得这两个数的最小公倍数-最大公约数的值最大，输出最大的值
 * 2<=n<=10^9
 */
public class BaiDuInterview {


    //投机取巧的办法，因为只要n>=3的时候，最大的最小的公倍数为n*(n-1)而最小的最大公约数为1
    public int process(int n){
        return n*(n-1)-1;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long start = System.currentTimeMillis();
        BaiDuInterview baiDuInterview = new BaiDuInterview();
        long end = System.currentTimeMillis();
        System.out.println("使用了："+(start-end));
        System.out.println(baiDuInterview.solution(n));

    }

    public int solution(int n){

        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i!=j){
                    int a = lcm(i,j)-gcd(i,j);
                    if (a>max) max = a;
                }

            }
        }
        return max;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }


}
