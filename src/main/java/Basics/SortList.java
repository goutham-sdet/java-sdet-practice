package Basics;

import java.util.*;

public class SortList
{
    public static void main (String[] args)
    {
        List<String> names = new ArrayList<>(Arrays.asList("Goutham" , "Bharath" , "Bablu"));
        Collections.sort(names);
        System.out.println(names);
    }
}
