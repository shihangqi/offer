package chapter4;

/**
 * @Author shihangqi
 * @Date 2020/4/1 13:59
 * @Version 1.0
 */

import java.util.*;

/**
 * 字符串的排列
 */

public class No38 {

    //在这里使用回溯法，适合这种题目，想要仔细了解的话可以搜一下回溯法的套路

    private Set<String> result = new HashSet<>();

    public String[] permutation(String s){
        if (s == null) return new String[]{};

        boolean[] visited = new boolean[s.length()];

        process(s,"",visited);

        return result.toArray(new String[result.size()]);

    }

    private void process(String s, String s1, boolean[] visited) {

        if (s.length() == s1.length()){
            result.add(s1);
            return;
        }

        for (int i = 0; i < s.length(); i++) {

            if (visited[i]) continue;
            char temp = s.charAt(i);
            visited[i] = true;
            process(s,s1+String.valueOf(temp),visited);
            visited[i] = false;
        }

    }

    //拓展问题n皇后问题

    public static void main(String[] args) {
        No38 no38 = new No38();
        System.out.println(no38.process2(4));
    }


    private List<List<String>> result1 = new ArrayList<>();

    public List<List<String>> process2(int n){
        if (n<=0) return result1;
        int[][] a = new int[n][n];
        boolean[] visitedCol = new boolean[n];
        process3(a,0,visitedCol);


        return result1;
    }

    private void process3(int[][] n, int row,boolean[] visitedCol) {
        if (n.length==row){
            result1.add(track(n));
            return;
        }
        for (int col = 0; col < n.length; col++) {
            if (visitedCol[col]) continue;
            visitedCol[col] = true;
            if (chack(n,row,col)){
                n[row][col] = 1;
                process3(n,row+1,visitedCol);
                n[row][col] = 0;
            }
            visitedCol[col] = false;

        }

    }

    private boolean chack(int[][] n, int row, int col){
        System.out.println(row);
        System.out.println(col);
        for (int i = 0; i < row; i++) {
            if (n[i][col]==1) return false;
        }
        for (int i = col-1; i >=0; i--) {
            if (i+row-col<0)break;
            if (n[i+row-col][i]==1)return false;
        }
        for (int i = col+1; i < n.length; i++) {
            if (row+col-i<0)break;
            if (n[row+col-i][i]==1)return false;
        }
        return true;
    }


    private List<String> track(int[][] n){
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n.length; j++) {
                if (n[i][j] == 0)
                    sb.append(".");
                else
                    sb.append("Q");
            }
            list.add(sb.toString());
        }
        return list;
    }


}
