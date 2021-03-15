package com.practise;

public class Test04 {

//	In an infinite binary tree,
//	left and right children of node A are A and B respectively
//	left and right children of node B are A and B respectively
//
//	ie.
//
//	        A
//	A                B
//
//
//	        B
//	B                A
//
//
//	Root of the tree is A
//	Find the element in Row - N, Column - M



    private static void findNode(int level, int index) {
        findNode('A', 0, level, index);
    }

    private static void findNode(char presentChar, int presentLevel,
            int level, int index) {
        if(level == presentLevel)
            System.out.println(presentChar);

        if(Math.pow(2, level-presentLevel)/ 2 > index) {  // goto rigt
            findNode('B', presentLevel++, level, index - (int)Math.pow(2, level-presentLevel)/ 2);
        } else {
            findNode('A', presentLevel++, level, index);
        }

    }

    public static void main(String[] args) {
        findNode(2, 3);

    }

}
