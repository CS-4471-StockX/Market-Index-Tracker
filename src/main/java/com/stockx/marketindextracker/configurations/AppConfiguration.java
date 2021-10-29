package com.stockx.marketindextracker.configurations;

import com.stockx.marketindextracker.adapters.FinancialModelingPrepAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

    @Bean
    public FinancialModelingPrepAdapter financialModelingPrepAdapter() {
        return new FinancialModelingPrepAdapter();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
