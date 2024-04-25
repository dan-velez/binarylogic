package com.blit.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.blit.entity.Market;
import com.blit.repository.MarketRepository;

@Service
public class MarketServiceImpl implements MarketService {
    @Autowired
    private MarketRepository repo;
    private static final Logger logger = LoggerFactory.getLogger(
        MarketServiceImpl.class);

    @Override
    public Market getMarket(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                "Could not find market with ID: "+id
            ));
    }

    @Override
    public Market getMarket(String name) {
        return repo.findMarketByName(name)
            .orElseThrow(() -> new ResourceNotFoundException(
                "Could not find market "+name));
    }

    @Override
    public List<Market> getMarkets() {
        return (List<Market>) repo.findAll();
    }

    @Override
    public void deleteMarket(Long id) {
        repo.deleteById(id);
    }
    
    @Override
    public Market saveMarket(Market market) {
        return repo.save(market);
    }
    
    @Override
    public Market updateMarket(Long id, Market market) {
        Optional<Market> omarket = repo.findById(id);
        logger.warn(omarket.toString());

        if(omarket.isPresent()) {
            logger.warn(omarket.toString());
            omarket.get().setVolume(market.getVolume());
            omarket.get().setTotalSupply(market.getTotalSupply());
            omarket.get().setName(market.getName());
            omarket.get().setMaxSupply(market.getMaxSupply());
            omarket.get().setMarketCap(market.getMarketCap());
            omarket.get().setLinks(market.getLinks());
            omarket.get().setCryptos(market.getCryptos());
            omarket.get().setCirculatingSupply(market.getCirculatingSupply());

            return repo.save(omarket.get());
        } else throw new ResourceNotFoundException(
            "Market not found: "+id
        );
    }
}
