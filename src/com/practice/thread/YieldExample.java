package com.practice.thread;

public class YieldExample
{

    public static void main(String[] args)
    {
        Runnable task = () ->
        {
            for (int i = 0; i%2==0; i++)
            {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                Thread.yield(); // Give other threads a chance to run
            }
        };



        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");

        thread1.start();
        thread2.start();
    }
}