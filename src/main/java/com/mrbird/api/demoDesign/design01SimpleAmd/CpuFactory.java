package com.mrbird.api.demoDesign.design01SimpleAmd;

/**
 *
 * XXXXXXX
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class CpuFactory {
    public static Cpu createCpu(int type) {
        Cpu cpu = null;
        if (type == 1) {
            cpu = new IntelCpu(755);
        } else if (type == 2) {
            cpu = new AmdCpu(938);
        }
        return cpu;
    }
}