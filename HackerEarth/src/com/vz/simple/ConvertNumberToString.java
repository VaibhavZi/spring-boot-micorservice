package com.vz.simple;

import java.util.Scanner;

public class ConvertNumberToString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        String s=""+n;
        if(Integer.parseInt(s)>100)
            System.out.println("Great work!!!");
        else
            System.out.println("Ok work!!!");
    }
}
