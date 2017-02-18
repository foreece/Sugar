package com.reece.network.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Reece
 * @version V1.0
 * @Date 2/17/17
 * @Description
 */

public class ThreadExecutor {
    private static ThreadExecutor INSTANCE;
    private ExecutorService mExecutorService;
    private ThreadExecutor() {
        mExecutorService = Executors.newFixedThreadPool(10);
    }

    public static ThreadExecutor get() {
        if (INSTANCE == null ) {
            synchronized (ThreadExecutor.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ThreadExecutor();
                }
            }
        }
        return INSTANCE;
    }

    public void submit(Runnable runnable) {
        mExecutorService.submit(runnable);
    }

    public void submit(Callable callable) {
        mExecutorService.submit(callable);
    }

    public void shutdown(){
        try {
            mExecutorService.shutdown();
            //等待6秒钟
            mExecutorService.awaitTermination(6, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            mExecutorService.shutdownNow();
        }
    }
}
