package concurrent.threadpool;

import java.util.concurrent.*;

public class Test implements Runnable, Callable {
    /**
     * 固定线程数
     */
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
    /**
     * 具有伸缩性 线程空闲60s后回收
     */
    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    /**
     * 只有一个核心线程的线程池
     */
    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    /**
     * 定时任务
     */
    ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
    /**
     * fork / join 线程池
     */
    ExecutorService workStealingPool = Executors.newWorkStealingPool();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Test test = new Test();
        test.fixedThreadPool.execute(test);

        FutureTask<String> futureTask = new FutureTask<String>(test);
        test.fixedThreadPool.submit(futureTask);
        String s = futureTask.get();
    }

    @Override
    public void run() {

    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}
