package com.goutham.sdet.basics;

public class Factorial_Iterative {
    public static void main(String[] args)
    {
        int num = 15;
        int fact = 1;

        for (int i=1;i<=num;i++)
        {
            fact = fact*i;
        }
        System.out.println("The factorial of " + num + " is " + fact + " (Iterative method)");
    }
}
