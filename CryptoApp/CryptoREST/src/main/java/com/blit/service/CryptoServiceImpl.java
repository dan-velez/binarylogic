package com.blit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.blit.entity.Crypto;
import com.blit.repository.CryptoRepository;

@Service
public class CryptoServiceImpl implements CryptoService {
    
    @Autowired
    private CryptoRepository cryptoRepo;

    @Override
    public List<Crypto> getCryptos() {
        return (List<Crypto>) cryptoRepo.findAll();
    }

    @Override
    public Crypto getCryptoById(Long id) {
        Optional<Crypto> crypto = cryptoRepo.findById(id);
        if(crypto.isPresent()) {
            return crypto.get();
        } else {
            throw new ResourceNotFoundException(
                "No crypto found with id: "+id);
        }
    }

    @Override
    public Crypto saveCrypto(Crypto crypto) {
        return cryptoRepo.save(crypto);
    }

    @Override
    public Crypto updateCrypto(Long id, Crypto crypto) {
        Optional<Crypto> oCrypto = cryptoRepo.findById(id);
        if(oCrypto.isPresent()) {
            oCrypto.get().setSymbol(crypto.getSymbol());
            oCrypto.get().setOpen(crypto.getOpen());
            oCrypto.get().setMarket(crypto.getMarket());
            oCrypto.get().setLow(crypto.getLow());
            oCrypto.get().setHigh(crypto.getHigh());
            oCrypto.get().setDatetime(crypto.getDatetime());
            oCrypto.get().setClose(crypto.getClose());
            oCrypto.get().setChange(crypto.getChange());

        return oCrypto.get();
        } else {
            throw new ResourceNotFoundException("Crypto "+id+" does not exist");
        }
    }

    @Override
    public void deleteCrypto(Long id) {
        cryptoRepo.deleteById(id);
    }
}
