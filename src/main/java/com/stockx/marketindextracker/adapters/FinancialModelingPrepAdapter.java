package com.stockx.marketindextracker.adapters;

import com.stockx.marketindextracker.HistoricalMarketIndexPrice;
import com.stockx.marketindextracker.MarketIndex;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
public class FinancialModelingPrepAdapter {

    private static final String BASE_URL = "https://financialmodelingprep.com/api/v3/";

    private RestTemplate restTemplate;
    private final String apiToken1;
    private final String apiToken2;


    public HistoricalMarketIndexPrice getHistoricalMarketIndexPriceByTicker(String ticker) {
        HistoricalMarketIndexPrice result = null;
        try {
            result = restTemplate.getForObject(getUrlForHistoricalMarketIndexPriceByTicker(apiToken1, ticker), HistoricalMarketIndexPrice.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.FORBIDDEN) {
                result = restTemplate.getForObject(getUrlForHistoricalMarketIndexPriceByTicker(apiToken2, ticker), HistoricalMarketIndexPrice.class);
            }
        }
        return result;
    }

    public MarketIndex[] getCurrentIndex(String ticker) {
        MarketIndex[] result = null;
        try {
            result = restTemplate.getForObject(getUrlForCurrentIndex(apiToken1, ticker), MarketIndex[].class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.FORBIDDEN) {
                result = restTemplate.getForObject(getUrlForCurrentIndex(apiToken2, ticker), MarketIndex[].class);
            }
        }
        return result;
    }

    private String getUrlForHistoricalMarketIndexPriceByTicker(String apiToken, String ticker) {
        return UriComponentsBuilder.fromUriString(BASE_URL).path("/historical-price-full/index")
                .pathSegment(ticker)
                .queryParam("apikey", apiToken).build().toUriString();
    }

    private String getUrlForCurrentIndex(String apiToken, String ticker) {
        return UriComponentsBuilder.fromUriString(BASE_URL).path("/quote")
                .pathSegment(ticker)
                .queryParam("apikey", apiToken).build().toUriString();
    }
}
