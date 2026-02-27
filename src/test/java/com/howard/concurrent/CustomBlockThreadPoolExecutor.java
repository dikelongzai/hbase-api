package com.howard.concurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomBlockThreadPoolExecutor {
    private ThreadPoolExecutor pool = null;

    /**
     * 线程池初始化方法
     * <p>
     * corePoolSize 核心线程池大小----1
     * maximumPoolSize 最大线程池大小----3
     * keepAliveTime 线程池中超过corePoolSize数目的空闲线程最大存活时间----30+单位TimeUnit
     * TimeUnit keepAliveTime时间单位----TimeUnit.MINUTES
     * workQueue 阻塞队列----new ArrayBlockingQueue<Runnable>(5)====5容量的阻塞队列
     * threadFactory 新建线程工厂----new CustomThreadFactory()====定制的线程工厂
     * rejectedExecutionHandler 当提交任务数超过maxmumPoolSize+workQueue之和时,
     * 即当提交第41个任务时(前面线程都没有执行完,此测试方法中用sleep(100)),
     * 任务会交给RejectedExecutionHandler来处理
     */

    public void init() {
        pool = new ThreadPoolExecutor(1, 3, 30L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5), new CustomerThreadFactory(), new CustomerRejectedExecutionHandler() {
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            }
        });

    }

    /**
     * 销毁线程池
     */
    public void destory() {
        if (pool != null) {
            pool.shutdown();

        }
    }

    /**
     * 获取ExecutorService ThreadPoolExecutor是ExecutorService的实现
     *
     * @return
     */
    public ExecutorService getCustomerBlockThreadPoolExecutor() {
        return pool;
    }

    /**
     * <p>构建threadTactory和非阻塞的threadFactory一样</p>
     */
    private class CustomerThreadFactory implements ThreadFactory {
        AtomicInteger count = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            String threadName = CustomBlockThreadPoolExecutor.class.getSimpleName() + count.getAndAdd(1);
            System.out.println("threadName = [" + threadName + "]");
            t.setName(threadName);
            return t;
        }
    }
}
