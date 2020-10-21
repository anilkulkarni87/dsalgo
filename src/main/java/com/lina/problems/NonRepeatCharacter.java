package com.lina.problems;

import java.util.HashMap;

public class NonRepeatCharacter {
    public static void main(String[] args) {

        //System.out.println(firstNonRepeatedCharacter("aabcde"));
        System.out.println(replace("ABC","AB"));
    }

    public static Character firstNonRepeatedCharacter(String str) {
        HashMap<Character, Integer> stringMap = new HashMap<Character, Integer>();
        for(int i=0; i<str.length(); i++){
            Character search = str.charAt(i);
            if(stringMap.containsKey(search)){
                stringMap.put(search,stringMap.get(search) +1);
            }else{
                stringMap.put(search,1);
            }
        }
        for(Character c : stringMap.keySet()){
            if(stringMap.get(c) == 1){
                return c;
            }
        }

        return null;

    }

    /*You are given an m x n 2D image matrix where each integer represents a pixel. Flip it in-place along its horizontal axis.

Example:

Input image :
              1 1
              0 0
Modified to :
              0 0
              1 1
    * */
    public static void flipHorizontalAxis(int[][] matrix) {
        int rows = matrix.length-1;
        int columns = matrix[0].length-1;

        for(int i=0;i<=rows/2;i++){
            for(int j=0; j<=columns; j++){
                int tmp = matrix[i][j];
                System.out.println(matrix.length -1-i);
                matrix[i][j] = matrix[matrix.length -1-i][j];
                matrix[matrix.length -1-i][j] = tmp;
            }
        }

    }

    public static String replace(String a, String b) {
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<a.length(); i++){
            if(a.charAt(i) == ' '){
                builder.append(b);
            }
            else{
                builder.append(a.charAt(i));
            }
        }

        return builder.toString();

    }
}
