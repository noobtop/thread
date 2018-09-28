package com.noob.top.FalseDemo;

public class DeadLockThead {

    public static void main(String[] args) {

        DeadLockThreadOne demo = new DeadLockThreadOne();
        DeadLockThreadTwo demo2 = new DeadLockThreadTwo();
        demo.startTwoThreads();
        //demo2.startTwoThreads();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("day after 5s…… ");
    }


}

class DeadLockThreadOne
{
    private static String  countA = "countA";
    private static String  countB = "countB";

    private void getCountByNums()
    {
        System.out.println("线程1开始……");
        synchronized (countA)
        {
            System.out.println("线程1拿到A锁……");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (countB)
            {
                System.out.println("线程1拿到B锁……");
            }
        }


    }

    private void getNumsByCount()
    {
        System.out.println("线程2开始……");
        synchronized (countB)
        {
            System.out.println("线程2拿到B锁……");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (countA)
            {
                System.out.println("线程2拿到A锁……");
            }
        }


    }

    public void startTwoThreads()
    {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                getCountByNums();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                getNumsByCount();
            }
        });

        t1.start();
        t2.start();
    }

}

class DeadLockThreadTwo
{
    private static Integer  countA = 1;
    private static Integer  countB = 2;

    private void getCountByNums()
    {
        System.out.println("线程1开始……");
        synchronized (countA)
        {
            System.out.println("线程1拿到A锁……");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (countB)
            {
                System.out.println("线程1拿到B锁……");
            }
        }

    }

    private void getNumsByCount()
    {
        System.out.println("线程2开始……");
        synchronized (countB)
        {
            System.out.println("线程2拿到B锁……");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (countA)
            {
                System.out.println("线程2拿到A锁……");
            }
        }


    }

    public void startTwoThreads()
    {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                getCountByNums();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                getNumsByCount();
            }
        });

        t1.start();
        t2.start();
    }

}