public class MyThreadPrim extends Thread{

    OptimisticListPrim<Integer> list;

    public MyThreadPrim(OptimisticListPrim<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        list.add(5);
    }
}
