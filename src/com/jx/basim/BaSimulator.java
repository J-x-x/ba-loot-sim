package com.jx.basim;

public class BaSimulator {

    private static LootUtils lootUtils = new LootUtils();
    private static GrandExchangeUtils grandExchangeUtils = new GrandExchangeUtils();

    public static void main(String[] args) {

        Interface i = new Interface(lootUtils, grandExchangeUtils, 0);

        String rollOutput = i.PerformRolls(4);
        System.out.println(rollOutput);
    }
}
