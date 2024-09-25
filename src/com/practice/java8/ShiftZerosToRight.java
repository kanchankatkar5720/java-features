package com.practice.java8;

import java.util.Arrays;

public class ShiftZerosToRight {

    public static void shiftZerosToRight(int[] arr)
    {
        int j = 0;

        for (int i = 0; i < arr.length; i++)
        {

            if (arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
        }

        while (j < arr.length) {
            arr[j] = 0;
            j++;
        }
    }

    public static void shiftZerosToLeft(int[] arr)
    {
        int j = arr.length-1;
        for (int i = arr.length-1; i >= 0; i--)
        {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                j--;
            }
        }
        while (j >0) {
            arr[j] = 0;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 0, 4, 0, 2, 5, 7, 0, 0, 9, 0};
        System.out.println("Original array: " + Arrays.toString(arr));

        // Call the function to shift all zeros to the right
        shiftZerosToRight(arr);

        // Output the modified array
        System.out.println("\nArray after shifting zeros to right: " + Arrays.toString(arr));
        shiftZerosToLeft(arr);
        System.out.println("\nArray after shifting zeros to left: " + Arrays.toString(arr));
    }
}
