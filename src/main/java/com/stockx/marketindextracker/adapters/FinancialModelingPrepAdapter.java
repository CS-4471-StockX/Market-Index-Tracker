package com.stockx.marketindextracker.adapters;

import com.stockx.marketindextracker.HistoricalMarketIndexPrice;
import com.stockx.marketindextracker.MarketIndex;
import com.stockx.marketindextracker.MarketIndexWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Objects;

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

    public MarketIndexWrap getCurrentIndex(String ticker){
        String url = UriComponentsBuilder.fromUriString(BASE_URL).path("/quote")
                .pathSegment(ticker)
                .queryParam("apikey", "bed2d806b7cbf8b5a704526ebb96b62e").build().toUriString();

        return new MarketIndexWrap(Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(url, MarketIndex[].class))));
    }
}
