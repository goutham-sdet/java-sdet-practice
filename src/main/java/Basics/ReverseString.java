package Basics;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the text which needs to be reversed : ");
        String given = sc.nextLine();
        String reversed = "";

        for(int i = given.length()-1; i>=0; i--)
        {
            reversed = reversed + given.charAt(i);
        }

        System.out.println("The Reversed Version of the given string is " + reversed);
    }
}
