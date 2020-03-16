package concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class Demo extends Thread {
    @Override
    public void run() {
        System.out.println("数据导入完毕，开始分析");
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Demo());
        new Thread(new DataImportThread(cyclicBarrier, "file1")).start();
        new Thread(new DataImportThread(cyclicBarrier, "file2")).start();
        new Thread(new DataImportThread(cyclicBarrier, "file3")).start();
    }
}
