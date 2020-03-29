package chapter2; /**
 * @Author shihangqi
 * @Date 2020/3/20 10:55
 * @Version 1.0
 */

/**
 * 二进制中1的个数
 */
public class No15 {

    public static void main(String[] args) {
        System.out.println(process(15));
    }

    //java中有两种右移符号，>>是有符号的右移，当数字是负数的时候会在头部添加1，>>>是无符号的右移，无论
    //正负号都是添加0。所以这里应该用无符号的右移。
    public static int process(int n){
        int count = 0;
        while (n!=0){
            if ((n&1)==1)count++;
            n = n>>>1;
        }
        return count;
    }

}
