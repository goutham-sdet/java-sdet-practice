package Basics;

import java.util.Set;
import java.util.HashSet;

public class FindDuplicates
{
    public static void main (String[] args)
    {
        int[] arr = { 1, 2 , 4, 5 , 6 , 3, 2, 1, 5};
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num : arr)
        {
            if (!seen.add(num))
            {
                duplicates.add(num);
            }
        }
        System.out.println(duplicates);
    }
}