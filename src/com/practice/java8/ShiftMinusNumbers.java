package com.practice.java8;

import java.util.Arrays;

public class ShiftMinusNumbers
{
    public static void main(String[] args) {
        int[] arr =  {-1, -2, -5, 0, 0, 0, -2, -5, -7, 0, 0, 0, 0};

        shiftMinusNumsToRight(arr);
        // Output the modified array
        System.out.println("\nArray after shifting zeros to right: " + Arrays.toString(arr));

    }

    private static void shiftMinusNumsToRight(int[] arr)
    {
        int j = 0;
        for(int i=0; i<= arr.length-1;i++)
        {
            if(arr[i] < 0)
            {
                arr[j] = arr[i];
                j++;
            }
        }

        while(j < arr.length)
        {
            arr[j] = 0;
            j++;
        }
    }
}
