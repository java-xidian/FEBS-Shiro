package com.mrbird.api.demoDesign.design08Component.demo2Pay;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/5
 */

public class PayDemo {


    public static void main(String[] args) {
        MarketBranch rootBranch = new MarketBranch("总店");
        MarketBranch qhdBranch = new MarketBranch("秦皇岛分店");
        MarketJoin hgqJoin = new MarketJoin("秦皇岛分店一海港区加盟店");
        MarketJoin btlJoin = new MarketJoin("秦皇岛分店二白塔岭加盟店");
        qhdBranch.add(hgqJoin);
        qhdBranch.add(btlJoin);
        rootBranch.add(qhdBranch);
        rootBranch.PayByCard();

    }

}

