package com.blit.service;

import java.util.List;

import com.blit.entity.Market;

public interface MarketService {
    Market getMarket(Long id);
    Market getMarket(String name);
    List<Market> getMarkets();
    void deleteMarket(Long id);
    Market saveMarket(Market market);
    Market updateMarket(Long id, Market market);
}
