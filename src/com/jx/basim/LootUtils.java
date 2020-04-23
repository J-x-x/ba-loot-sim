package com.jx.basim;

import java.util.*;

public class LootUtils {

    Random random;
    ArrayList<Reward> lootTable = new ArrayList<>();

    HashMap<String, Integer> rollTracker = new HashMap<>();

    public LootUtils() {
        random = new Random();
    }

    public double CalculateWeight(double chance, double in) {
            return chance/in;
    }

    public void AddReward(Reward reward) {
        lootTable.add(reward);
        rollTracker.put(reward.getName(),0);
    }

    public Reward RollReward() {
        double roll = random.nextDouble();
        double count = 0;
        Reward reward;

        for (int i = 0; i< lootTable.size(); i++) {
            reward = lootTable.get(i);
            if (count + reward.getWeight() >= roll) {
                rollTracker.put(reward.getName(), rollTracker.get(reward.getName()) + rollQuantity(reward));
                return reward;
            } else {
                count = count + reward.getWeight();
            }
        }

        return null;
    }

    private Integer rollQuantity(Reward reward) {
        Integer roll = random.nextInt(reward.getMaxQuantity() - reward.getMinQuantity() + 1);
        return reward.getMinQuantity() + roll;
    }

    public String GetRollTrackerResults() {
        String results = "";
        for (String key : rollTracker.keySet()) {
            results = results + key + ": " + rollTracker.get(key) + "\n";
        }
        return results;
    }

    public void SortLootTable() {
        Collections.sort(lootTable, new Comparator<Reward>() {
            @Override
            public int compare(Reward reward, Reward t1) {
                return (reward.getWeight() >= t1.getWeight()) ? 1 : -1;
            }
        });
    }

}
