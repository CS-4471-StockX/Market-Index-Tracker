package com.stockx.marketindextracker.configurations;

import com.stockx.marketindextracker.adapters.FinancialModelingPrepAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

    @Value("${financialModelingPrep.apiKey1}")
    private String financialModelingPrepApiKey1;
    @Value("${financialModelingPrep.apiKey2}")
    private String financialModelingPrepApiKey2;

    @Bean
    public FinancialModelingPrepAdapter financialModelingPrepAdapter(RestTemplate restTemplate) {
        return new FinancialModelingPrepAdapter(restTemplate, financialModelingPrepApiKey1, financialModelingPrepApiKey2);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
