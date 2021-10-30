package com.stockx.marketindextracker;

import lombok.Data;

import java.util.List;

@Data
public class HistoricalMarketIndexPrice {

    private String symbol;
    List<MarketIndexDayEnd> historical;
}
