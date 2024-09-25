package com.practice.java8;

public class SumOfAllDigits {

    int sum = 0;

    int sumOfAllDigits(int inputNumber)
    {
        if(inputNumber == 0)
        {
            return sum;
        }
        else
        {
            int lastDigit = inputNumber%10;
            sum = sum + lastDigit;
            inputNumber = inputNumber/10;
            sumOfAllDigits(inputNumber);
        }

        return sum;
    }

    public static void main(String[] args)
    {
        SumOfAllDigits mainClass = new SumOfAllDigits();

        System.out.println(mainClass.sumOfAllDigits(12345));
    }
}
