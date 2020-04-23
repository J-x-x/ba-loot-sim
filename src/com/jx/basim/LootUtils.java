package com.jx.basim;

import java.util.*;

public class LootUtils {

    Random random;
    ArrayList<Reward> lootTable = new ArrayList<>();

    TreeMap<String,Integer> lootTracker = new TreeMap<>();

    public LootUtils() {
        random = new Random();
        lootTracker.put("Pet Pennance Queen", 0);
        lootTracker.put("Elite Clue Scroll", 0);
    }

    public double CalculateWeight(double chance, double in) {
            return chance/in;
    }

    public void AddReward(Reward reward) {
        lootTable.add(reward);
        lootTracker.put(reward.getName(),0);
    }

    public void RollReward() {
        double roll = random.nextDouble();
        double count = 0;
        Reward reward;

        for (Reward value : lootTable) {
            reward = value;
            if (count + reward.getWeight() >= roll) {
                lootTracker.put(reward.getName(), lootTracker.get(reward.getName()) + rollQuantity(reward));
                break;
            } else {
                count = count + reward.getWeight();
            }
        }

        if (random.nextDouble() <= 0.001) {
            lootTracker.put("Pet Pennance Queen", lootTracker.get("Pet Pennance Queen") + 1);
        } else if (random.nextDouble() <= 0.066) {
            lootTracker.put("Elite Clue Scroll", lootTracker.get("Elite Clue Scroll") + 1);
        }
    }

    private Integer rollQuantity(Reward reward) {
        Integer roll = random.nextInt(reward.getMaxQuantity() - reward.getMinQuantity() + 1);
        return reward.getMinQuantity() + roll;
    }

    public String GetRollTrackerResults() {
        StringBuilder results = new StringBuilder();
        for (String key : lootTracker.keySet()) {
            results.append(key).append(": ").append(lootTracker.get(key)).append("\n");
        }
        return results.toString();
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
