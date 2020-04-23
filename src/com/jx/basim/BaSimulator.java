package com.jx.basim;

public class BaSimulator {

    private static LootUtils lootUtils = new LootUtils();
    private static GrandExchangeUtils grandExchangeUtils = new GrandExchangeUtils();

    public static void main(String[] args) {

        Interface i = new Interface(lootUtils, grandExchangeUtils);

        String rollOutput = i.PerformRolls(100);
        System.out.println(rollOutput);
    }
}
