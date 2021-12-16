import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        OptimisticList<Integer> list = new OptimisticList<>();


        for (int i = 0; i <= 100000; i++) {
            list.add(i);
        }
        List<Thread> threadList = new ArrayList<>();


        long time = System.nanoTime();
        for(int i=1;i<=4;i++){
            MyThread t = new MyThread(list);
            t.start();
            threadList.add(t);
        }

        for(var t: threadList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long finalTime = System.nanoTime();
        System.out.println("Optimizat: " + (finalTime - time) + " nanosecunde");


        OptimisticListPrim<Integer> list2 = new OptimisticListPrim<>();


        for (int i = 0; i <= 100000; i++) {
            list2.add(i);
        }
        List<Thread> threadList2 = new ArrayList<>();


        long time2 = System.nanoTime();
        for(int i=1;i<=4;i++){
            MyThreadPrim t = new MyThreadPrim(list2);
            t.start();
            threadList2.add(t);
        }

        for(var t: threadList2) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long finalTime2 = System.nanoTime();
        System.out.println("Neoptimizat: " + (finalTime2 - time2) + " nanosecunde");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("time.txt"));
            writer.write("Optimizat: " + (finalTime - time) + " nanosecunde\n");
            writer.write("Neoptimizat: " + (finalTime2 - time2) + " nanosecunde");
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
