package com.reece.network.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Reece
 * @version V1.0
 * @Date 2/17/17
 * @Description
 */

public class ThreadPool {
    private static ThreadPool INSTANCE;
    private ExecutorService mExecutorService;
    private ThreadPool() {
        mExecutorService = Executors.newFixedThreadPool(10);
    }

    public static ThreadPool get() {
        if (INSTANCE == null ) {
            synchronized (ThreadPool.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ThreadPool();
                }
            }
        }
        return INSTANCE;
    }

    public void execute(Runnable runnable) {
        mExecutorService.execute(runnable);
    }
}
