package com.stockx.marketindextracker.services;

import com.stockx.marketindextracker.HistoricalMarketIndexPrice;
import com.stockx.marketindextracker.adapters.FinancialModelingPrepAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketIndexTrackerServices {

    @Autowired
    FinancialModelingPrepAdapter financialModelingPrepAdapter;

    public HistoricalMarketIndexPrice getHistoricalMarketIndexPriceByTicker(String ticker) {
        return financialModelingPrepAdapter.getHistoricalMarketIndexPriceByTicker(ticker);
    }
}
