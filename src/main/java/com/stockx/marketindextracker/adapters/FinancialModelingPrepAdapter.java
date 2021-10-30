package com.stockx.marketindextracker.adapters;

import com.stockx.marketindextracker.HistoricalMarketIndexPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class FinancialModelingPrepAdapter {

    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL = "https://financialmodelingprep.com/api/v3/";

    public HistoricalMarketIndexPrice getHistoricalMarketIndexPriceByTicker(String ticker) {
        String url = UriComponentsBuilder.fromUriString(BASE_URL).path("/historical-price-full/index")
                .pathSegment(ticker)
                .queryParam("apikey", "bed2d806b7cbf8b5a704526ebb96b62e").build().toUriString();

        return restTemplate.getForObject(url, HistoricalMarketIndexPrice.class);
    }
}
