package com.stockx.marketindextracker;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;


@Data
public class MarketIndex {
    @JsonAlias("name")
    private String name;

    @JsonAlias("price")
    private double price;

    @JsonAlias("changesPercentage")
    private double changesPercentage;

    @JsonAlias("change")
    private double change;

    @JsonAlias("dayLow")
    private double dayLow;

    @JsonAlias("dayHigh")
    private double dayHigh;

}
