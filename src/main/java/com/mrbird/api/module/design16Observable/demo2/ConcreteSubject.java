package com.mrbird.api.module.design16Observable.demo2;

/**
 * 　　拉模型的具体主题类
 * 　　跟推模型相比，有一点变化，就是调用通知观察者的方法的时候，不需要传入参数了。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */
public class ConcreteSubject extends Subject {

    private String state;

    public String getState() {
        return state;
    }

    public void change(String newState) {
        state = newState;
        System.out.println("主题状态为：" + state);
        //状态发生改变，通知各个观察者
        this.nodifyObservers();
    }
}

