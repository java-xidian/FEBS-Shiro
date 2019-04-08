package com.mrbird.api.demoThread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/4/8
 */
public class CookFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        // 第一步 网购厨具
        BuyChuJu buyChuJu = new BuyChuJu();
        FutureTask<Chuju> task = new FutureTask<Chuju>(buyChuJu);
        new Thread(task).start();
        // 第二步 去超市购买食材
        // 模拟购买食材时间
        Thread.sleep(2000);
        Shicai shicai = new Shicai();
        System.out.println("第二步：食材到位");
        // 第三步 用厨具烹饪食材
        // 联系快递员，询问是否到货
        if (!task.isDone()) {
            System.out.println("第三步：厨具还没到，心情好就等着（心情不好就调用cancel方法取消订单）");
        }
        Chuju chuju = task.get();
        System.out.println("第三步：厨具到位，开始展现厨艺");
        cook(chuju, shicai);

        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * 用厨具烹饪食材
     *
     * @param chuju
     * @param shicai
     */
    static void cook(Chuju chuju, Shicai shicai) {
    }

    // 厨具类
    static class Chuju {
    }

    // 食材类
    static class Shicai {
    }

    /**
     * 买厨具
     */
    static class BuyChuJu implements Callable<Chuju> {
        @Override
        public Chuju call() throws Exception {
            System.out.println("第一步：下单");
            System.out.println("第一步：等待送货");
            // 模拟送货时间
            Thread.sleep(5000);
            System.out.println("第一步：快递送到");
            return new Chuju();
        }
    }

}

