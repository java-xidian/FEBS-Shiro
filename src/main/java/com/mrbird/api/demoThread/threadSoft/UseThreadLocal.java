package com.mrbird.api.demoThread.threadSoft;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/4/9
 */
public class UseThreadLocal {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void setThreadLocal(String value) {
        threadLocal.set(value);
    }

    public String getThreadLocal() {
        return threadLocal.get();
    }

    public static void main(String[] args) {

        UseThreadLocal utl = new UseThreadLocal();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                utl.setThreadLocal("张三");
                System.err.println("当前t1线程拿到的值 : " + utl.getThreadLocal());
            }
        }, "t1");


        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                utl.setThreadLocal("李四");
                System.err.println("当前t2线程拿到的值 : " + utl.getThreadLocal());
            }
        }, "t2");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();
        t2.start();
        System.err.println("主线程拿到的值 : " + utl.getThreadLocal());
    }


}
