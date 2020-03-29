package chapter3; /**
 * @Author shihangqi
 * @Date 2020/3/20 15:57
 * @Version 1.0
 */


/**
 * 打印从1到最大的n位数
 */
public class No17 {

    public static void process(int n){
        if (n<=0) return;

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < n; i++) {
            s.append("0");
        }
        while(stillIncrease(s, n)){
            print(s);
        }

    }

    public static boolean stillIncrease(StringBuilder s,int n){

        int toTen = 0;
        // 从个位开始加，如果有进位就看十位...如果到最高位还有进位，说明溢出；
        for (int i = n - 1; i >= 0; i--) {
            // 加上进位toTen
            int sum = s.charAt(i) - '0' + toTen;
            // 在个位上，先自增
            if (i == n - 1) {
                sum++;
            }

            if (sum == 10) {
                // 进位溢出
                if (i == 0) {
                    return false;
                    // 需要进位，当前位设为0
                } else {
                    s.setCharAt(i, '0');
                    // 进位了
                    toTen = 1;
                }
            } else {
                s.setCharAt(i, (char) (sum + '0'));
                // 在某位上自增后不再进位，自增完成立即退出循环
                break;
            }
        }
        return true;
    }

    public static void print(StringBuilder s){
        int start = s.length();
        // 找到第一个不为0的索引
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                start = i;
                break;
            }
        }
        // 如果全是0，就不会打印
        if (start < s.length()) {
            System.out.print(s.substring(start) + " ");
        }
    }


}
