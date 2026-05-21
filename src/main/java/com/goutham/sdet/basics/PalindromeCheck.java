package com.goutham.sdet.basics;

import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the word to be checked : ");
        String actual = sc.nextLine();
        String reversed = "";

        for(int i = actual.length()-1 ; i >=0 ; i--)
        {
            reversed = reversed + actual.charAt(i);
        }

        if(actual.equals(reversed))
        {
            System.out.println(actual + " is a Palindrome");
        }
        else
        {
            System.out.println("oops!! " + actual + " is not a Palindrome");
        }
    }
}
