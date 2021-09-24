package MultiThreading;
class MyThread3 extends Thread{
    public void run()
    {
        System.out.println(Thread.currentThread().getName());
        for(int i=0;i<10;i++)
        {
            System.out.println("Child thread");
           // Thread.yield();
        }
    }

}

public class ThreadPriority {
    public static void main(String args[]){
        MyThread3 t=new MyThread3();
        t.start();
        t.setPriority(10);
        t.setName("Child");
        Thread.currentThread().setPriority(1);
        Thread.currentThread().setName("First");

        System.out.println(Thread.currentThread().getName());
        for(int i=0;i<10;i++)
        {
            System.out.println("main thread");
        }

    }
}

