package com.jx.basim;

import java.util.TreeMap;

public class Interface {

    private LootUtils lootUtils;
    private GrandExchangeUtils grandExchangeUtils;

    public Interface(LootUtils lootUtils, GrandExchangeUtils grandExchangeUtils) {
        this.lootUtils = lootUtils;
        this.grandExchangeUtils = grandExchangeUtils;
        CreateLootTable();
    }

    public String PerformRolls(Integer rolls) {
        Integer lootValue = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= rolls; i++) {
            lootUtils.RollReward();
        }

        TreeMap<Reward, Integer> lootTracker = lootUtils.GetRollTrackerResults();

        stringBuilder = stringBuilder.append("You rolled: ");

        for (Reward reward : lootTracker.keySet()) {
            if (lootTracker.get(reward) > 0) {
                lootValue = lootValue + reward.getGrandExchangeValue() * lootTracker.get(reward);
                stringBuilder.append("\n")
                        .append(reward.getName())
                        .append(": ").append(lootTracker.get(reward))
                        .append(" worth ")
                        .append(grandExchangeUtils.ShortenValue(reward.getGrandExchangeValue() * lootTracker.get(reward)))
                        .append("!");
            }
        }

        stringBuilder.append("\nTotal Value: ").append(grandExchangeUtils.ShortenValue(lootValue));

        return stringBuilder.toString();
    }

    private void CreateLootTable() {
        lootUtils.AddReward(new Reward(253, "Dragon Chainbody", lootUtils.CalculateWeight(1, 16000), 1, 1, grandExchangeUtils.GetValue(253)));
        lootUtils.AddReward(new Reward(1149, "Dragon Med Helm", lootUtils.CalculateWeight(1, 16000), 1, 1, grandExchangeUtils.GetValue(1149)));
        lootUtils.AddReward(new Reward(257, "Ranarr Weed", lootUtils.CalculateWeight(499.9375, 16000), 20, 30, grandExchangeUtils.GetValue(257)));
        lootUtils.AddReward(new Reward(3000, "Snapdragon", lootUtils.CalculateWeight(499.9375, 16000), 20, 30, grandExchangeUtils.GetValue(3000)));
        lootUtils.AddReward(new Reward(269, "Torstol", lootUtils.CalculateWeight(499.9375, 16000), 20, 30, grandExchangeUtils.GetValue(269)));
        lootUtils.AddReward(new Reward(5295, "Ranarr Seed", lootUtils.CalculateWeight(499.9375, 16000), 3, 4, grandExchangeUtils.GetValue(5295)));
        lootUtils.AddReward(new Reward(5300, "Snapdragon Seed", lootUtils.CalculateWeight(499.9375, 16000), 3, 4, grandExchangeUtils.GetValue(5300)));
        lootUtils.AddReward(new Reward(5304, "Torstol Seed", lootUtils.CalculateWeight(499.9375, 16000), 3, 4, grandExchangeUtils.GetValue(5304)));
        lootUtils.AddReward(new Reward(5321, "Watermelon Seed", lootUtils.CalculateWeight(499.9375, 16000), 50, 50, grandExchangeUtils.GetValue(5321)));
        lootUtils.AddReward(new Reward(5289, "Palm Tree Seed", lootUtils.CalculateWeight(499.9375, 16000), 1, 2, grandExchangeUtils.GetValue(5289)));
        lootUtils.AddReward(new Reward(5316, "Magic Seed", lootUtils.CalculateWeight(499.9375, 16000), 1, 1, grandExchangeUtils.GetValue(5316)));
        lootUtils.AddReward(new Reward(3749, "Archer Helm", lootUtils.CalculateWeight(499.9375, 16000), 1, 1, grandExchangeUtils.GetValue(3749)));
        lootUtils.AddReward(new Reward(3751, "Berserker Helm", lootUtils.CalculateWeight(499.9375, 16000), 1, 1, grandExchangeUtils.GetValue(3751)));
        lootUtils.AddReward(new Reward(3753, "Warrior Helm", lootUtils.CalculateWeight(499.9375, 16000), 1, 1, grandExchangeUtils.GetValue(3753)));
        lootUtils.AddReward(new Reward(3755, "Farseer Helm", lootUtils.CalculateWeight(499.9375, 16000), 1, 1, grandExchangeUtils.GetValue(3755)));
        lootUtils.AddReward(new Reward(3122, "Granite Shield", lootUtils.CalculateWeight(499.9375, 16000), 1, 1, grandExchangeUtils.GetValue(3122)));
        lootUtils.AddReward(new Reward(10589, "Granite Helm", lootUtils.CalculateWeight(499.9375, 16000), 1, 1, grandExchangeUtils.GetValue(10589)));
        lootUtils.AddReward(new Reward(1201, "Rune Kiteshield", lootUtils.CalculateWeight(499.9375, 16000), 1, 1, grandExchangeUtils.GetValue(1201)));
        lootUtils.AddReward(new Reward(453, "Coal", lootUtils.CalculateWeight(499.9375, 16000), 750, 750, grandExchangeUtils.GetValue(453)));
        lootUtils.AddReward(new Reward(451, "Runite Ore", lootUtils.CalculateWeight(499.9375, 16000), 20, 20, grandExchangeUtils.GetValue(451)));
        lootUtils.AddReward(new Reward(2363, "Runite Bar", lootUtils.CalculateWeight(499.9375, 16000), 15, 15, grandExchangeUtils.GetValue(2363)));
        lootUtils.AddReward(new Reward(536, "Dragon Bones", lootUtils.CalculateWeight(499.9375, 16000), 50, 75, grandExchangeUtils.GetValue(536)));
        lootUtils.AddReward(new Reward(1747, "Black Dragonhide", lootUtils.CalculateWeight(499.9375, 16000), 30, 50, grandExchangeUtils.GetValue(1747)));
        lootUtils.AddReward(new Reward(1617, "Uncut Diamond", lootUtils.CalculateWeight(499.9375, 16000), 25, 30, grandExchangeUtils.GetValue(1617)));
        lootUtils.AddReward(new Reward(1513, "Magic Logs", lootUtils.CalculateWeight(499.9375, 16000), 50, 100, grandExchangeUtils.GetValue(1513)));
        lootUtils.AddReward(new Reward(8782, "Mahogany Plank", lootUtils.CalculateWeight(499.9375, 16000), 60, 80, grandExchangeUtils.GetValue(8782)));
        lootUtils.AddReward(new Reward(892, "Rune Arrow", lootUtils.CalculateWeight(499.9375, 16000), 400, 500, grandExchangeUtils.GetValue(892)));
        lootUtils.AddReward(new Reward(383, "Raw Shark", lootUtils.CalculateWeight(499.9375, 16000), 250, 300, grandExchangeUtils.GetValue(383)));
        lootUtils.AddReward(new Reward(385, "Shark", lootUtils.CalculateWeight(499.9375, 16000), 75, 125, grandExchangeUtils.GetValue(385)));
        lootUtils.AddReward(new Reward(563, "Law Rune", lootUtils.CalculateWeight(499.9375, 16000), 250, 300, grandExchangeUtils.GetValue(563)));
        lootUtils.AddReward(new Reward(565, "Blood Rune", lootUtils.CalculateWeight(499.9375, 16000), 250, 300, grandExchangeUtils.GetValue(565)));
        lootUtils.AddReward(new Reward(225, "Limpwurt Root", lootUtils.CalculateWeight(499.9375, 16000), 30, 50, grandExchangeUtils.GetValue(225)));
        lootUtils.AddReward(new Reward(237, "Unicorn Horn", lootUtils.CalculateWeight(499.9375, 16000), 30, 50, grandExchangeUtils.GetValue(237)));
        lootUtils.AddTertiaryReward(new Reward(12073, "Clue Scroll (Elite)", lootUtils.CalculateWeight(1, 15), 1, 1, grandExchangeUtils.GetValue(12073)));
        lootUtils.AddTertiaryReward(new Reward(12703, "Pet Penance Queen", lootUtils.CalculateWeight(1, 1000), 1, 1, grandExchangeUtils.GetValue(12703)));
    }
}
