package com.blit.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blit.entity.Market;
import com.blit.service.MarketService;

@RestController
@RequestMapping("/api/v1/market")
public class MarketController {
    @Autowired
    private MarketService service;

    @GetMapping("all")
    public ResponseEntity<List<Market>> getMarkets() {
        return new ResponseEntity<>(service.getMarkets(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Market> getMarket(@PathVariable Long id) {
        return new ResponseEntity<>(service.getMarket(id), 
            HttpStatus.OK);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Market> getMarket(@PathVariable String name) {
        return new ResponseEntity<>(service.getMarket(name),
            HttpStatus.CREATED);
    }

    // @PostMapping
    // public ResponseEntity
    
}
