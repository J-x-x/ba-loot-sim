package com.jx.basim;

import java.util.*;

public class LootUtils {

    Random random;
    ArrayList<Reward> lootTable = new ArrayList<>();
    ArrayList<Reward> tertiaryLootTable = new ArrayList<>();

    TreeMap<Reward, Integer> lootTracker = new TreeMap<>();

    public LootUtils() {
        random = new Random();
    }

    public double CalculateWeight(double chance, double in) {
        return chance / in;
    }

    public void AddReward(Reward reward) {
        lootTable.add(reward);
        lootTracker.put(reward, 0);
    }

    public void AddTertiaryReward(Reward reward) {
        tertiaryLootTable.add(reward);
        lootTracker.put(reward, 0);
    }

    public void RollReward() {
        double roll = random.nextDouble();
        double count = 0;

        for (Reward reward : lootTable) {
            if (count + reward.getWeight() >= roll) {
                lootTracker.put(reward, lootTracker.get(reward) + rollQuantity(reward));
                break;
            } else {
                count = count + reward.getWeight();
            }
        }

        count = 0;
        for (Reward reward : tertiaryLootTable) {
            if (count + reward.getWeight() >= roll) {
                lootTracker.put(reward, lootTracker.get(reward) + rollQuantity(reward));
                break;
            } else {
                count = count + reward.getWeight();
            }
        }
    }

    private Integer rollQuantity(Reward reward) {
        Integer roll = random.nextInt(reward.getMaxQuantity() - reward.getMinQuantity() + 1);
        return reward.getMinQuantity() + roll;
    }

    public TreeMap<Reward, Integer> GetRollTrackerResults() {
        return lootTracker;
    }

    public void SortLootTable() {
        lootTable.sort(new Comparator<>() {
            @SuppressWarnings("ComparatorMethodParameterNotUsed")
            @Override
            public int compare(Reward reward, Reward t1) {
                return reward.getWeight() >= t1.getWeight() ? 1 : -1;
            }
        });
    }

}
