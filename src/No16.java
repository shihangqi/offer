/**
 * @Author shihangqi
 * @Date 2020/3/20 11:33
 * @Version 1.0
 */

/**
 *  数值的整数次方
 */
public class No16 {

    public static void main(String[] args) {
        System.out.println(power2(10, 4));
    }


    public static double power(double base,int exponent){

        if (base==0) return 0;

        double result =1.0;
        int positiveExponent = Math.abs(exponent);
        for (int i = 0; i < positiveExponent; i++) {
            result *=base;
        }

        return exponent<0 ? 1/result : result;
    }

    public static double power2(double base,int exponent){
        if (base==0)return 0;

        double result = 1.0;

        int positiveExponent = Math.abs(exponent);

        while (positiveExponent!=0){
            if((positiveExponent&1) ==1){
                result *= base;
            }
            base *= base;
            positiveExponent = positiveExponent >> 1;
        }
        return exponent<0?1/result:result;
    }

}
