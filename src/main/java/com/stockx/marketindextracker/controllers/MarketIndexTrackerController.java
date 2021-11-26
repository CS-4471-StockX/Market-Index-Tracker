package com.stockx.marketindextracker.controllers;

import com.stockx.marketindextracker.HistoricalMarketIndexPrices;
import com.stockx.marketindextracker.MarketIndex;
import com.stockx.marketindextracker.services.MarketIndexTrackerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketIndexTrackerController {

    @Autowired
    MarketIndexTrackerServices marketIndexTrackerServices;

    @CrossOrigin(origins = "https://www.stockx.software")
    @GetMapping("/historical/market-index-price")
    public HistoricalMarketIndexPrices getHistoricalMarketIndexPriceByTicker(@RequestParam("ticker") String ticker) {
        return marketIndexTrackerServices.getHistoricalMarketIndexPriceByTicker(ticker);
    }

    @CrossOrigin(origins = "https://www.stockx.software")
    @GetMapping("/market-index")
    public MarketIndex getMarketIndexByTicker(@RequestParam("ticker") String ticker) {
        return marketIndexTrackerServices.getMarkerIndexByTicker(ticker);
    }
}
