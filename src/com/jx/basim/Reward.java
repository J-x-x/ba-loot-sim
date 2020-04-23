package com.jx.basim;

public class Reward implements Comparable<Reward> {

    private String name;
    private Integer itemID;
    private double weight;
    private Integer minQuantity;
    private Integer maxQuantity;
    private Integer grandExchangeValue;

    public String getName() {
        return name;
    }

    public Integer getItemID() {
        return itemID;
    }

    public double getWeight() {
        return weight;
    }

    public Integer getMinQuantity() {
        return minQuantity;
    }

    public Integer getMaxQuantity() {
        return maxQuantity;
    }

    public Integer getGrandExchangeValue() {
        return grandExchangeValue;
    }


    public Reward(Integer itemID, String name, double weight, Integer minQuantity, Integer maxQuantity, Integer grandExchangeValue) {
        this.name = name;
        this.weight = weight;
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
        this.itemID = itemID;
        this.grandExchangeValue = grandExchangeValue;
    }

    @Override
    public int compareTo(Reward reward) {
        return this.getName().compareTo(reward.getName());
    }
}
