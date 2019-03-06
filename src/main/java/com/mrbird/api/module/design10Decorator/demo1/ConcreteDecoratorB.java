package com.mrbird.api.module.design10Decorator.demo1;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/5
 */
public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        super.sampleOperation();
        // 写相关的业务代码
    }
}
