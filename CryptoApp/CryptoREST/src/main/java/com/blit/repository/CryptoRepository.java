package com.blit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.blit.entity.Crypto;

public interface CryptoRepository extends CrudRepository<Crypto, Long> {

    Crypto findCryptoBySymbol(String symbol);
    //List<Crypto> findCryptosByMarket(String marketName);
}