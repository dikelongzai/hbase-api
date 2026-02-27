package com.howard.concurrent;

import com.howard.util.LRUCache;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ConcurrentTest {
    @Test
    public void testConcurrent() {
        CustomBlockThreadPoolExecutor exec = new CustomBlockThreadPoolExecutor();
        // 1.初始化
        exec.init();
        ExecutorService pool = exec.getCustomerBlockThreadPoolExecutor();
        for (int i = 1; i < 100; i++) {
            System.out.println("提交第" + i + "个任务!");
//            System.out.println("getTaskCount=" + exec.getCustomerBlockThreadPoolExecutor() + ";getActiveCount" + exec.getCustomerBlockThreadPoolExecutor().getActiveCount());
//            System.out.println("getQueue size=" + exec.getCustomerBlockThreadPoolExecutor() + ";getCompletedTaskCount=" + exec.getCustomerBlockThreadPoolExecutor().getCompletedTaskCount());
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(">>>task is running=====");
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });
        }
    }

    @Test
    public void testLRU() {
        LRUCache<Integer, Integer> lRUCache = new LRUCache<>(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        Assert.assertEquals(1, lRUCache.get(1).intValue());
        ;
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        Assert.assertEquals(-1, lRUCache.get(2).intValue());
        ;

        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        Assert.assertEquals(-1, lRUCache.get(1).intValue());
        ;
        Assert.assertEquals(3, lRUCache.get(3).intValue());
        ;
        Assert.assertEquals(4, lRUCache.get(4).intValue());
        ;


    }

}

