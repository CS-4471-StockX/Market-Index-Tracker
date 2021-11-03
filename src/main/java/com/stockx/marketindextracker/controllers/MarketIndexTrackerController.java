package com.stockx.marketindextracker.controllers;

import com.stockx.marketindextracker.HistoricalMarketIndexPrice;
import com.stockx.marketindextracker.MarketIndex;
import com.stockx.marketindextracker.MarketIndexWrap;
import com.stockx.marketindextracker.services.MarketIndexTrackerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketIndexTrackerController {

    @Autowired
    MarketIndexTrackerServices marketIndexTrackerServices;

    @GetMapping("/historical/market-index-price")
    public HistoricalMarketIndexPrice getHistoricalMarketIndexPriceByTicker(@RequestParam("ticker") String ticker) {
        return marketIndexTrackerServices.getHistoricalMarketIndexPriceByTicker(ticker);
    }

    @GetMapping("/market-index")
    public MarketIndexWrap getMarketIndexByTicker(@RequestParam("ticker") String ticker){
        return marketIndexTrackerServices.getMarkerIndexByTicker(ticker);
    }
}
