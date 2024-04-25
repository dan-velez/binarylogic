package com.blit.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.blit.entity.Market;

public interface MarketRepository extends CrudRepository<Market, Long> {

    Optional<Market> findMarketByName (String name);

}
