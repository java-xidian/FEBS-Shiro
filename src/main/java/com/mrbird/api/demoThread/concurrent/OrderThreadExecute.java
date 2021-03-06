package com.mrbird.api.demoThread.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/4/9
 */
public class OrderThreadExecute {

    /**
     * 员工干完活
     */
    class Worker implements Runnable {
        private CountDownLatch countDownLatch;
        private String name;

        public Worker(CountDownLatch downLatch, String name) {
            this.countDownLatch = downLatch;
            this.name = name;
        }

        @Override
        public void run() {
            this.doWork();
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(10));
            } catch (InterruptedException ie) {
            }
            System.out.println(this.name + "活干完了！");
            this.countDownLatch.countDown();
        }

        private void doWork() {
            System.out.println(this.name + "正在干活...");
        }

    }

    /**
     * 老板在等待
     */
    class Boss implements Runnable {
        private CountDownLatch downLatch;

        public Boss(CountDownLatch downLatch) {
            this.downLatch = downLatch;
        }

        @Override
        public void run() {
            System.out.println("老板正在等所有的工人干完活......");
            try {
                this.downLatch.await();
            } catch (InterruptedException e) {
            }
            System.out.println("工人活都干完了，老板开始检查了！");
        }

    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(3);

        OrderThreadExecute orderThread = new OrderThreadExecute();

        Worker w1 = orderThread.new Worker(latch, "张三");
        Worker w2 = orderThread.new Worker(latch, "李四");
        Worker w3 = orderThread.new Worker(latch, "王二");

        Boss boss = orderThread.new Boss(latch);

        executor.execute(boss);
        executor.execute(w3);
        executor.execute(w2);
        executor.execute(w1);

        executor.shutdown();

    }


}
