package Basics;

public class Fibonacci {
 public static void main(String[] args)
 {
     int first = 0;
     int second = 1;
     int next;

     int count = 10;

     for(int i=1;i<=count;i++)
     {
         System.out.print(first + " ");
         next = first + second;
         first = second;
         second = next;
     }
 }
}
