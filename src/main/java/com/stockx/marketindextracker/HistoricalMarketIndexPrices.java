package com.stockx.marketindextracker;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HistoricalMarketIndexPrices {

    private String symbol;
    private HistoricalMarketIndexPriceDTO fiveDay;
    private HistoricalMarketIndexPriceDTO oneMonth;
    private HistoricalMarketIndexPriceDTO oneYear;
    private HistoricalMarketIndexPriceDTO fiveYear;
}
