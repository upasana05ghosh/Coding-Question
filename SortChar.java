package com.practise;

public class SortChar {

    int a = 1;
    public static void main(String[] args) {
        char[] colors = { 'b', 'g', 'r', 'r', 'g', 'g', 'b', 'r', 'r' };
        System.out.println("Before  : " + new String(colors));
        //groupColors(colors);


        SortChar ob = new SortChar();
        ob.a = 1;
        ob.groupColors(colors);
        System.out.println("After   : " + new String(colors));
        // gbr
        //gggrrrbbr
        //: gggbbrrrr

    }

    private static void groupColors(char[] colors) {
        int i = 0, n = colors.length - 1;

        //System.out.println(this.a);
        int gFlag = 0, rFlag = n - 1;

        while (i <= rFlag) {
            if (colors[i] == 'g') {
                swap(colors, i, gFlag);
                gFlag++;
                i++;
            } else if (colors[i] == 'r') {
                swap(colors, i, rFlag);
                rFlag--;
            } else {
                i++;
            }
        }
    }

    private static void swap(char[] colors, int i, int j) {
        char temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }

}
