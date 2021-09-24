package MultiThreading;
class MyThread4 extends Thread{
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("Child thread");
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

}

public class UsingJoin{
    public static void main(String args[]) throws InterruptedException{
        MyThread4 t=new MyThread4();
        t.start();
        t.join();
        for(int i=0;i<10;i++)
        {
            System.out.println("main thread");
        }

    }
}

