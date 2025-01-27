package com.practice.exception;

public class FinallyExample {
    public static void main(String[] args) throws Exception {
        int a=10, b=0;
        try
        {
            int c = a/b;

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("In catch block  " +e.getMessage());
        }
        finally {
            System.out.println("In finally block  ");
            throw new Exception("In finally block exception");

        }
    }
}
