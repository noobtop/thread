package com.noob.top.FalseDemo;

public class NotSefeThread
{

    public static void main(String[] args) {
        for(int i = 0 ; i < 15 ; i++){

            NotSefeThreadOne demo  = new NotSefeThreadOne();
            demo.addCount();
            try{

                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.err.println(e);
            }
            System.err.println("count: " + demo.getCount());
        }
    }
}

class NotSefeThreadOne{

    private int count = 0;


    public void addCount()
    {
        for(int i=0;i<500;i++)
        {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {


                    try{
                        Thread.sleep(50);
                    }
                    catch (Exception e)
                    {
                        System.out.println("e:" + e);
                    }
                    count +=1;
                    // System.err.println("count:" + count );
                }
            });

            t.start();
        }


    }

    public int getCount(){
        return this.count;
    }
}
