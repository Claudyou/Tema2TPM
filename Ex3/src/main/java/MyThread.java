public class MyThread extends Thread{

    OptimisticList<Integer> list;

    public MyThread(OptimisticList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        list.add(5);
    }
}
