package com.blit.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "market")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Market {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // @OneToMany(cascade = CascadeType.ALL)
    // @JsonIgnore
    // private List<Crypto> cryptos;

    private String name;
    private double marketCap;
    private double volume;
    private double circulatingSupply;
    private double totalSupply;
    private double maxSupply;
    private String[] links;

    public Market() {}
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    // public List<Crypto> getCryptos() {
    //     return this.cryptos;
    // }
    // public void setCryptos(List<Crypto> cryptos) {
    //     this.cryptos = cryptos;
    // }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getMarketCap() {
        return marketCap;
    }
    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }
    public double getVolume() {
        return volume;
    }
    public void setVolume(double volume) {
        this.volume = volume;
    }
    public double getCirculatingSupply() {
        return circulatingSupply;
    }
    public void setCirculatingSupply(double circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }
    public double getTotalSupply() {
        return totalSupply;
    }
    public void setTotalSupply(double totalSupply) {
        this.totalSupply = totalSupply;
    }
    public double getMaxSupply() {
        return maxSupply;
    }
    public void setMaxSupply(double maxSupply) {
        this.maxSupply = maxSupply;
    }
    public String[] getLinks() {
        return links;
    }
    public void setLinks(String[] links) {
        this.links = links;
    }

}