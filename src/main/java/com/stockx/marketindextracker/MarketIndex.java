package com.stockx.marketindextracker;


import lombok.Data;


@Data
public class MarketIndex {
    private String name;
    private double price;
    private double changesPercentage;
    private double change;
    private double dayLow;
    private double dayHigh;

}
