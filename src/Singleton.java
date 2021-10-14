import java.sql.Array;
import java.util.ArrayList;
import java.util.concurrent.*;

public class Singleton {
    public static void main(String[] args){
        // 创建单线程---以继承Thread的方式创建线程
        Threadclass c1 = new Threadclass();
        Threadclass c2 = new Threadclass();
        c1.start();
        c2.start();

        // 创建单线程---以实现Runnable接口的方式创建线程
        Threadclass1 r1 = new Threadclass1();
        Thread rt1 = new Thread(r1);
        rt1.start();

        // 创建单线程---以Calllable的方式
        Threadclass3 tc3 = new Threadclass3();
        FutureTask<String> futureTask = new FutureTask<String>(tc3);
        new Thread(futureTask).start();


        // 创建多线程--- 用线程池的方式创建
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(6));
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }


}

class Threadclass extends Thread{
    @Override
    public void run(){
        System.out.println("xiancheng");
    }

}

class Threadclass1 implements Runnable{
    @Override
    public void run(){
        System.out.println("Runnable");
    }
}
class Threadclass3 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Callable1");
        return "Callable2";

    }

}


