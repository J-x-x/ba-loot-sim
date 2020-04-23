package com.jx.basim;

public class Main {

    public static void main(String[] args) {
        LootUtils lootUtils = new LootUtils();

        lootUtils.AddReward(new Reward("D Chain", lootUtils.CalculateWeight(1,16000), 1, 1));
        lootUtils.AddReward(new Reward("D Med", lootUtils.CalculateWeight(1,16000), 1, 1));
        lootUtils.AddReward(new Reward("Ranarr Weed", lootUtils.CalculateWeight(499.9375,16000), 20, 30));
        lootUtils.AddReward(new Reward("Snapdragon", lootUtils.CalculateWeight(499.9375,16000), 20, 30));
        lootUtils.AddReward(new Reward("Torstol", lootUtils.CalculateWeight(499.9375,16000), 20, 30));
        lootUtils.AddReward(new Reward("Ranarr Seed", lootUtils.CalculateWeight(499.9375,16000), 3, 4));
        lootUtils.AddReward(new Reward("Snapdragon Seed", lootUtils.CalculateWeight(499.9375,16000), 3, 4));
        lootUtils.AddReward(new Reward("Torstol Seed", lootUtils.CalculateWeight(499.9375,16000), 3, 4));
        lootUtils.AddReward(new Reward("Watermelon Seed", lootUtils.CalculateWeight(499.9375,16000), 50, 50));
        lootUtils.AddReward(new Reward("Palm Tree Seed", lootUtils.CalculateWeight(499.9375,16000), 1, 2));
        lootUtils.AddReward(new Reward("Magic Seed", lootUtils.CalculateWeight(499.9375,16000), 1, 1));
        lootUtils.AddReward(new Reward("Archer Helm", lootUtils.CalculateWeight(499.9375,16000), 1, 1));
        lootUtils.AddReward(new Reward("Berserker Helm", lootUtils.CalculateWeight(499.9375,16000), 1, 1));
        lootUtils.AddReward(new Reward("Warrior Helm", lootUtils.CalculateWeight(499.9375,16000), 1, 1));
        lootUtils.AddReward(new Reward("Farseer Helm", lootUtils.CalculateWeight(499.9375,16000), 1, 1));
        lootUtils.AddReward(new Reward("Granite Shield", lootUtils.CalculateWeight(499.9375,16000), 1, 1));
        lootUtils.AddReward(new Reward("Granite Helm", lootUtils.CalculateWeight(499.9375,16000), 1, 1));
        lootUtils.AddReward(new Reward("Rune Kiteshield", lootUtils.CalculateWeight(499.9375,16000), 1, 1));
        lootUtils.AddReward(new Reward("Coal", lootUtils.CalculateWeight(499.9375,16000), 750, 750));
        lootUtils.AddReward(new Reward("Runite Ore", lootUtils.CalculateWeight(499.9375,16000), 20, 20));
        lootUtils.AddReward(new Reward("Runite Bar", lootUtils.CalculateWeight(499.9375,16000), 15, 15));
        lootUtils.AddReward(new Reward("Dragon Bones", lootUtils.CalculateWeight(499.9375,16000), 50, 75));
        lootUtils.AddReward(new Reward("Black Dragonhide", lootUtils.CalculateWeight(499.9375,16000), 30, 50));
        lootUtils.AddReward(new Reward("Uncut Diamond", lootUtils.CalculateWeight(499.9375,16000), 25, 30));
        lootUtils.AddReward(new Reward("Magic Logs", lootUtils.CalculateWeight(499.9375,16000), 50, 100));
        lootUtils.AddReward(new Reward("Mahogany Plank", lootUtils.CalculateWeight(499.9375,16000), 60, 80));
        lootUtils.AddReward(new Reward("Rune Arrow", lootUtils.CalculateWeight(499.9375,16000), 400, 500));
        lootUtils.AddReward(new Reward("Raw Shark", lootUtils.CalculateWeight(499.9375,16000), 250, 300));
        lootUtils.AddReward(new Reward("Shark", lootUtils.CalculateWeight(499.9375,16000), 75, 125));
        lootUtils.AddReward(new Reward("Law Rune", lootUtils.CalculateWeight(499.9375,16000), 250, 300));
        lootUtils.AddReward(new Reward("Blood Rune", lootUtils.CalculateWeight(499.9375,16000), 250, 300));
        lootUtils.AddReward(new Reward("Limpwurt Root", lootUtils.CalculateWeight(499.9375,16000), 30, 50));
        lootUtils.AddReward(new Reward("Unicorn Horn", lootUtils.CalculateWeight(499.9375,16000), 30, 50));
        lootUtils.AddReward(new Reward("Coins", lootUtils.CalculateWeight(499.9375,16000), 50000, 70000));

        lootUtils.SortLootTable();

        for (int i = 1; i <= 1; i++) {
            lootUtils.RollReward();
        }

        System.out.println(lootUtils.GetRollTrackerResults());
    }
}
