package MultiThreading;
class MyThread5 extends Thread{
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Child thread");
                Thread.sleep(2300);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}

public class ThreadInterrupt {
    public static void main(String args[]){
        MyThread5 t=new MyThread5();
        t.start();
        t.interrupt();
        for(int i=0;i<10;i++)
        {
            System.out.println("main thread");
        }

    }
}

