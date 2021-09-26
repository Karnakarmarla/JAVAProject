package MultiThreading;
import java.util.*;


class Task{
    long id;
    String name;
    public Task(long id,String name)
    {
        this.id=id;
        this.name=name;
    }
}

class Producer implements Runnable{
    private LinkedList<Task> list;
    private int capacity;
    public Producer(LinkedList<Task> list,int capacity)
    {
        this.list=list;
        this.capacity=capacity;
    }

    public void run(){
        long id = 1;
        for (int i = 0; i < 10; i++) {
            synchronized (list) {
                while (list.size() == capacity) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String name = "Task" + Long.toString(id);
                System.out.println("Producer produced-" + id+" Task Name: "+name);
                Task t = new Task(id, name);
                list.add(t);
                id++;
                list.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

class Consumer implements Runnable{
    private LinkedList<Task> list;
    private int capacity = 2;
    public Consumer(LinkedList<Task> list,int capacity)
    {
        this.list=list;
        this.capacity=capacity;
    }

    public void run() {
        while (true) {
            synchronized (list) {
                while (list.size() == 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Task task = list.removeFirst();
                System.out.println("Consumer consumed-" + task.id+" Task Name: "+task.name);
                list.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ProducerConsumerSolution {
    public static void main(String[] args)
    {
        LinkedList<Task> list = new LinkedList<>();
        int capacity = 2;
        Thread t1 = new Thread(new Producer(list,capacity));
        Thread t2 = new Thread(new Consumer(list,capacity));

        t1.start();
        t2.start();
    }
}