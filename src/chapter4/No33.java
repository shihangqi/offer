package chapter4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author shihangqi
 * @Date 2020/3/29 19:00
 * @Version 1.0
 */

/**
 * 二叉搜索树的后序遍历序列
 */
public class No33 {


    public boolean process(int[] sequence){
        if (sequence==null||sequence.length==0)return false;
        return isSearchBST(sequence,0,sequence.length-1);
    }

    private boolean isSearchBST(int[] seq, int begin, int end) {
        if (begin>=end) return true;

        int rootval = seq[end];
        int i = begin;
        while (i<end&&seq[i]<rootval){
            i++;
        }
        int boundary = i;
        while (i<end){
            if (seq[i]<rootval) return false;
            i++;
        }
        return isSearchBST(seq,0,boundary-1) && isSearchBST(seq,boundary,end-1);


    }

}
