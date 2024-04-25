package com.blit.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blit.entity.Crypto;
import com.blit.service.CryptoService;

@RestController
@ResponseBody
@RequestMapping("/api/v1/crypto")
public class CryptoController {
    
    @Autowired
    CryptoService service;

    @GetMapping("/all")
    public ResponseEntity<List<Crypto>> getCryptos() {
        return new ResponseEntity<>(service.getCryptos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Crypto> getCrypto(@PathVariable Long id) {
        return new ResponseEntity<>(service.getCryptoById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Crypto> saveCrypto(@RequestBody Crypto crypto) {
        return new ResponseEntity<>(service.saveCrypto(crypto), 
        HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Crypto> updateCrypto(@PathVariable Long id,
    @RequestBody Crypto crypto) {
        return new ResponseEntity<>(service.updateCrypto(id, crypto),
            HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Crypto> deleteCar(@PathVariable Long id) {
        service.deleteCrypto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
