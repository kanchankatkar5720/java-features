package com.practice.java8;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ArrayPrograms
{
    public static void main(String[] args)
    {
        Integer arr[] = {22, 14, 8, 17, 35, 3};

        Integer maxNumber = Arrays.stream(arr).max(Comparator.naturalOrder()).get();

        Integer minNumber = Arrays.stream(arr).min(Comparator.naturalOrder()).get();
        System.out.println("maxNumber : " +maxNumber +", MinNumber  : " +minNumber);

        List<Integer> list = Arrays.asList(arr);
        Collections.reverse(Arrays.asList(arr));
        System.out.println("Reversed Array: " + list);

        //rotate cyclic array
        int arrnum[] = {2,4,6,8,9,10,12,11,100,123,90};
        rotateRightByOne(arr);
        System.out.println("Rotated Array: " + Arrays.toString(arr));
        reverseArrayl(arr);
        System.out.println("Reverse Array : " +Arrays.toString(arr));

        reverseArray(arrnum);
        System.out.println("Reverse Array : " +Arrays.toString(arrnum));

        Integer[] arrDuplicate = {2, 10, 10, 100, 2, 10, 11, 2, 11, 2};
        List<Integer> duplicateNums = findDuplicate(arrDuplicate);
        System.out.println("picked only duplicate number : " +duplicateNums);

        //find number of occurances of number in array
        Integer arrOccurance[] = {1, 1, 2, 2, 2, 2, 3};
        findOccurance(arrOccurance);


    }

    private static void findOccurance(Integer[] arrOccurance)
    {
        Map<Integer, Long> findNumOcc = Arrays.stream(arrOccurance).collect(Collectors.groupingBy(num->num, Collectors.counting()));
        findNumOcc.forEach((num, timesOccur) -> System.out.println(num +" occurs "+timesOccur+" times in the given array."));
    }

    private static List<Integer> findDuplicate(Integer[] arrDuplicate)
    {
        List<Integer> duplicates = Arrays.stream(arrDuplicate)
                .collect(Collectors.groupingBy(num->num, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        Set<Integer> duplicateN = new HashSet<>();
        Set<Integer> duplicateNums = Arrays.stream(arrDuplicate).filter(num->!duplicateN.add(num))
                .collect(Collectors.toSet());
        System.out.println("Duplicate NUmbers " +duplicateNums);

        return  duplicates;


    }

    private static void rotateRightByOne(Integer[] arr)
    {
        int lastelement = arr[arr.length-1];
        if(arr==null || arr.length <= 1)
        {
            return;
        }
        for(int i=arr.length-1 ; i > 0 ; i--)
        {
            arr[i] = arr[i-1];
        }
        arr[0] = lastelement;
    }

    private static void reverseArrayl(Integer[] arr)
    {
        int left = 0;
        int right = arr.length - 1;
        //Integer[] temp =
        if (left <= right)
        {
            int temp = arr[left];
            arr[left] = arr [right];
            arr[right] =temp;
            left++;
            right--;
        }
    }
    static void reverseArray(int[] arr)
    {
        int n = arr.length;

        for (int i = 0; i < n / 2; i++)
        {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }
}
