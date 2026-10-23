package Basics;
import java.util.Map;
import java.util.LinkedHashMap;

public class Count_Frequency
{
    public static void main (String[] args)
    {
        String str = "Automation";
        Map<Character,Integer> occurence = new LinkedHashMap<>();

        for ( char ch : str.toLowerCase().toCharArray())
        {
            occurence.put (ch , occurence.getOrDefault( ch , 0) + 1);
        }
        System.out.println(occurence);
    }
}
