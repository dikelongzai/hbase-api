package com.howard.concurrent;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class CustomerRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        try {
            // 核心改造点，由blockingqueue的offer改成put阻塞方法
            executor.getQueue().put(r);
            System.out.println("error.............getActiveCount=" + executor.getActiveCount());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
