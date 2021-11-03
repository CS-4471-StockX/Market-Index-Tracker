package com.stockx.marketindextracker;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MarketIndexWrap {

    private List<MarketIndex> Indexes;

}
