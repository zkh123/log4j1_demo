package com.hlj.risk.pisk.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AdjustAmountThreadPool {

    private static final int defaultThreads = 1;

    private static AdjustAmountThreadPool threadPool;

    private static AdjustAmountThreadPool threadPool2;

    private ExecutorService service = null;

    public static AdjustAmountThreadPool getSingleInstance() {
        if (null == threadPool) {
            threadPool = new AdjustAmountThreadPool();
        }
        return threadPool;
    }

    public static AdjustAmountThreadPool initPool(int threads) {
        if (null == threadPool) {
            threadPool = new AdjustAmountThreadPool(threads);
        }
        return threadPool;
    }

    public static AdjustAmountThreadPool initPool2(int threads) {
        if (null == threadPool2) {
            threadPool2 = new AdjustAmountThreadPool(threads);
        }
        return threadPool2;
    }


    public AdjustAmountThreadPool() {
        service = Executors.newFixedThreadPool(defaultThreads);
    }

    public AdjustAmountThreadPool(int threads) {
        service = Executors.newFixedThreadPool(threads > 0 ? threads : defaultThreads);
    }

    public void excute(Thread thread) {
        service.execute(thread);
    }

    public void excute(Runnable runnable){
        service.execute(runnable);
    }

    public void shutdown(){
        service.shutdown();
    }

    public boolean isTerminated(){
        return service.isTerminated();
    }

}
