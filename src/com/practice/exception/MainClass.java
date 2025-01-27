package com.practice.exception;

class A
{
    static void methodOne()
    {
        System.out.println("AAA");
    }
}

class B extends A
{
    static void methodOne()
    {
        System.out.println("BBB");
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        B a = new B();

        a.methodOne();
    }
}