package concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class DataImportThread implements Runnable{

    private CyclicBarrier cyclicBarrier;
    private String fileName;

    public DataImportThread(CyclicBarrier cyclicBarrier, String fileName) {
        this.cyclicBarrier = cyclicBarrier;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println("开始导入数据" + fileName);
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
