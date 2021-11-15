package com.stockx.marketindextracker.services;

import com.stockx.marketindextracker.*;
import com.stockx.marketindextracker.adapters.FinancialModelingPrepAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketIndexTrackerServices {

    @Autowired
    FinancialModelingPrepAdapter financialModelingPrepAdapter;

    public HistoricalMarketIndexPrices getHistoricalMarketIndexPriceByTicker(String ticker) {
        HistoricalMarketIndexPriceDTO fiveDay = new HistoricalMarketIndexPriceDTO();
        HistoricalMarketIndexPriceDTO oneMonth = new HistoricalMarketIndexPriceDTO();
        HistoricalMarketIndexPriceDTO oneYear = new HistoricalMarketIndexPriceDTO();
        HistoricalMarketIndexPriceDTO fiveYear = new HistoricalMarketIndexPriceDTO();

        HistoricalMarketIndexPrice allHistoricalMarketIndexPrice = financialModelingPrepAdapter.getHistoricalMarketIndexPriceByTicker(ticker);
        int counter = 0;
        for (MarketIndexDayEnd marketIndexDayEnd : allHistoricalMarketIndexPrice.getHistorical()) {
            if (counter < 5) {
                fiveDay.getHistorical().put(marketIndexDayEnd.getDate(), marketIndexDayEnd.getClose());
            }
            if (counter < 21) {
                oneMonth.getHistorical().put(marketIndexDayEnd.getDate(), marketIndexDayEnd.getClose());
            }
            if (counter < 251) {
                oneYear.getHistorical().put(marketIndexDayEnd.getDate(), marketIndexDayEnd.getClose());
            }
            fiveYear.getHistorical().put(marketIndexDayEnd.getDate(), marketIndexDayEnd.getClose());
            counter++;
        }

        return new HistoricalMarketIndexPrices(ticker, fiveDay, oneMonth, oneYear, fiveYear);
    }

    public MarketIndex getMarkerIndexByTicker(String ticker) {
        return financialModelingPrepAdapter.getCurrentIndex(ticker)[0];
    }
}
