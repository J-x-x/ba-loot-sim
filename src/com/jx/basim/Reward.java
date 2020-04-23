package com.jx.basim;

public class Reward {

    public String getName() {
        return name;
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

    private String name;
    private double weight;
    private Integer minQuantity;
    private Integer maxQuantity;

    public Reward(String name, double weight, Integer minQuantity, Integer maxQuantity) {
        this.name = name;
        this.weight = weight;
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
    }

}
