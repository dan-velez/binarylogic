package com.blit.service;

import java.util.List;

import com.blit.entity.Crypto;

public interface CryptoService {
    public List<Crypto> getCryptos();
    Crypto getCryptoById(Long id);
    Crypto saveCrypto(Crypto crypto);
    Crypto updateCrypto(Long id, Crypto crypto);
    void deleteCrypto(Long id);
}
