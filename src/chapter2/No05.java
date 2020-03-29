package chapter2; /**
 * @Author shihangqi
 * @Date 2020/3/18 19:21
 * @Version 1.0
 */


/**
 * 面试题5：替换空格
 */
public class No05 {

    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder("We are hap py");

        System.out.println(process(stringBuilder));
    }
    public static StringBuilder process(StringBuilder str){

        if (str==null) return null;

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==' ')
                count++;
        }
        int oldLength = str.length()-1;

        str.setLength(str.length() + 2*count);

        int newLength = str.length()-1;

        while (oldLength >=0){
            if (str.charAt(oldLength) == ' '){
                str.setCharAt(newLength--, '0');
                str.setCharAt(newLength--, '2');
                str.setCharAt(newLength--, '%');
            }
            else {
                str.setCharAt(newLength--,str.charAt(oldLength));
            }
            oldLength--;
        }

        return str;
    }


}
