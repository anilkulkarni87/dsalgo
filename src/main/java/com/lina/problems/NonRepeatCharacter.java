package com.lina.problems;

import java.util.*;

public class NonRepeatCharacter {
    public static void main(String[] args) {

        //System.out.println(firstNonRepeatedCharacter("aabcde"));
        //System.out.println(replace("ABC","AB"));
        //System.out.println(singleNumber(new int[]{1, 1, 2, 2, 3, 4, 5}));
        //System.out.println(isIsomorphic("abcd","aabb"));
        //System.out.println(compressString("aaabbbbbcccc"));
        System.out.println(merge(new int[] {2,5,7,8},new int[] {2,4,7,12,32}));
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

    public static int singleNumber(int[] A) {
        Hashtable<Integer,Integer> hashtable = new Hashtable<Integer, Integer>();
        int singlenum=0;
        for(int i=0;i<A.length;i++){
            if(hashtable.containsKey(A[i])){
                hashtable.put(A[i],hashtable.get(A[i])+1);
            }else{
                hashtable.put(A[i],1);
            }
        }
        for(int key : hashtable.keySet()){
            if(hashtable.get(key) == 1) {
                singlenum = key;
            }
        }
        return singlenum;


    }

    public static ArrayList<String> removeDuplicates(List<String> input) {
        TreeSet<String> stringSet = new TreeSet<String>();
        for(int i=0; i< input.size(); i++){
            stringSet.add(input.get(i));
        }

        return new ArrayList(stringSet);
    }

    public static boolean isIsomorphic(String input1, String input2) {
        if(input1.length() != input2.length()){
            return false;
        }
        HashMap<Character, Character> encodeMap = new HashMap<Character, Character>();

        for(int i=0; i<input1.length();i++ ){
            Character c1 = input1.charAt(i);
            Character c2 = input2.charAt(i);
            if(encodeMap.containsKey(c1)){
                if(encodeMap.get(c1) != c2 ){
                    return false;
                }

            }else if(encodeMap.containsKey(c2)){
                return false;
            }else{
                encodeMap.put(c1,c2);
            }
        }
        return true;
    }

    public static String compressString(String text) {
        if(text == null || text == "" || text.length() == 1){
            return text;
        }
        StringBuilder builder = new StringBuilder();
        Character last = text.charAt(0);
        int count = 1;

        for(int i=1;i<text.length();i++){
            if(text.charAt(i) == last){
                count ++;
                continue;
            }
            builder.append(last);
            if(count>1){
                builder.append(Integer.toString(count));
            }
            last = text.charAt(i);
            count = 1;
        }
        builder.append(last);
        if(count>1){
            builder.append(Integer.toString(count));
        }

        return builder.toString();


    }

    public static int[] bubbleSortArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }


        return arr;
    }

    public static int[] merge(int[] arrLeft, int[] arrRight){
        int l1 = arrLeft.length;
        int r2 = arrRight.length;
        int[] mergedArr = new int[l1+r2];
        int i=0, j=0, k=0;

        while(i<l1 && j<r2){
            if(arrLeft[i]<arrRight[j]){
                mergedArr[k++] = arrLeft[i++];

            }else{
                mergedArr[k++] = arrRight[j++];
            }
        }

        while(i<l1){
            mergedArr[k++] = arrLeft[i++];
        }
        while(j<r2){
            mergedArr[k++] = arrRight[j++];
        }

        return mergedArr;

    }
}
