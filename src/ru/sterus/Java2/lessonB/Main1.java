package ru.sterus.Java2.lessonB;


import java.util.Arrays;

public class Main1 {

    private static String s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0 4";



    public static void main(String[] args){
        String[][] newStringArray = converter(s);
        System.out.println(Arrays.deepToString(newStringArray));
        int[][] newIntArray = converterStringArrayToIntArray(newStringArray);
        System.out.println(Arrays.deepToString(newIntArray));
    }

    private static String[][] converter(String src){
        try {
            char[] src1 = new char[src.length()];
            src1 = src.toCharArray();
            String[][] out = new String[4][4];
            String word = "";
            int nowI = 0;
            int nowJ = 0;

            for (int i = 0; i < src1.length; i++) {
                if (src1[i] != ' ' && src1[i] != '\n') {
                    word += src1[i];
                    if (i == src1.length - 1) {
                        out[nowI][nowJ] = word;
                    }
                } else if (src1[i] == ' ') {
                    out[nowI][nowJ] = word;
                    word = "";
                    nowJ += 1;
                } else if (src1[i] == '\n') {
                    out[nowI][nowJ] = word;
                    word = "";
                    nowJ = 0;
                    nowI += 1;
                }
            }
            return out;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array index out of bounds");
        }
        return null;
    }
    private static int[][] converterStringArrayToIntArray(String[][] src){
        int[][] out = new int[4][4];
        int now;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                try {
                    Integer i1 = new Integer(src[i][j]);
                    out[i][j] = i1;
                } catch (NumberFormatException e){
                    System.out.println("Bad things happened");
                }
            }
        }
        return out;

    }
}
