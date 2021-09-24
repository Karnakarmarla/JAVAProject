package MultiThreading;
class MyThread2 implements Runnable{
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("Child thread");
        }
    }

}

public class UsingRunnable {
    public static void main(String args[]){
        MyThread2 t=new MyThread2();
        Thread t1=new Thread(t);
        t1.start();
        for(int i=0;i<10;i++)
        {
            System.out.println("main thread");
        }

    }
}

