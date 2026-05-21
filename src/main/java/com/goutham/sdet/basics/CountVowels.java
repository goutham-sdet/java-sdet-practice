package com.goutham.sdet.basics;

import java.util.Scanner;

public class CountVowels {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Please enter the text to count the Vowels present in it : ");
        String entered = sc.nextLine();
        entered = entered.toLowerCase();
        int count = 0;

        for(int i =0; i< entered.length(); i++)
        {
            char letter = entered.charAt(i);

            if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u')
            {
                count++;
            }
        }
        System.out.println(" The Number of Vowels present in the entered word is " + count);
    }
}
