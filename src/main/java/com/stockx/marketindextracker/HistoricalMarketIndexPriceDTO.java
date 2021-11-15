package com.stockx.marketindextracker;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class HistoricalMarketIndexPriceDTO {

    Map<String, Double> historical;

    public HistoricalMarketIndexPriceDTO() {
        this.historical = new LinkedHashMap<>();
    }
}
