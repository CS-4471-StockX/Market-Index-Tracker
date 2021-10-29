package com.stockx.marketindextracker;

import lombok.Data;

@Data
public class MarketIndexDayEnd {

    private String date;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Double adjClose;
    private Long volume;
    private Long unadjustedVolume;
    private Double change;
    private Double changePercent;
    private Double vwap;
    private Double changeOverTime;

}
