package MultiThreading;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;


class Task1{
    long id;
    String name;
    public Task1(long id,String name)
    {
        this.id=id;
        this.name=name;
    }
}

class Producer1 implements Runnable{
    private BlockingQueue<Task1> blockingQueue;
    public Producer1(BlockingQueue<Task1> blockingQueue)
    {
        this.blockingQueue=blockingQueue;
    }

    public void run(){
        long id = 1;
        try {
            for (int i = 0; i < 10; i++) {
                String name = "Task" + Long.toString(id);
                System.out.println("Producer produced-" + id + " Task Name: " + name);
                Task1 t = new Task1(id, name);
                blockingQueue.put(t);
                id++;
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}

class Consumer1 implements Runnable{
    private BlockingQueue<Task1> blockingQueue;
    public Consumer1(BlockingQueue<Task1> blockingQueue)
    {
        this.blockingQueue=blockingQueue;
    }

    public void run() {
        try {
            while (true) {
                Task1 task = blockingQueue.take();
                System.out.println("Consumer consumed-" + task.id + " Task Name: " + task.name);
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class ExecutorsProducerConsumer{
    public static void main(String[] args)
    {
        BlockingQueue<Task1> blockingQueue = new LinkedBlockingDeque<>(2);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Thread t1 = new Thread(new Producer1(blockingQueue));
        Thread t2 = new Thread(new Consumer1(blockingQueue));

        executor.execute(t1);
        executor.execute(t2);
        executor.shutdown();
    }
}