package com.practice.java8;

import java.util.HashMap;
import java.util.Map;

public class IterateHashMapClass
{
    public static void main(String[] args)
    {
        Map<String, String> testMap = new HashMap<String, String>();

        testMap.put("A", "Angular");
        testMap.put("J", "Java");
        testMap.put("P", "Python");
        testMap.put("H", "Hibernate");

        //normal
        for(Map.Entry<String, String> entrymap : testMap.entrySet())
        {
              //  System.out.println(entrymap.getKey() +"  " +entrymap.getValue());
        }

        //using foreach
       // testMap.forEach((key, value) -> System.out.println(key +"  " +value)) ;

        //using stream
        testMap.entrySet().stream()
                .forEach(inputvalues -> System.out.println(inputvalues.getKey() +" " +inputvalues.getValue()));



    }
}
