package com.goutham.sdet.basics;

public class Factorial_Recursive {
    static int factorial(int n)
    {
        if(n==0)
        {
            return 1;
        }
        return n*factorial(n-1); // a method calling by itself
    }

    public static void main(String[] args)
    {
        int num = 25;
        int result = factorial(num);
        System.out.println("The factorial of " + num + " is " + result +  " (Recursive method)");
    }
}
