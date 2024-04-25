package com.blit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "crypto")
public class Crypto {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "market")
    private Market market;

    private String symbol;
    private String datetime;
    private double openPrice;
    private double high;
    private double low;
    private double closePrice;
    private double changeBar;

    public Crypto() {}

    public Crypto(String symbol, String datetime, double open, double high, 
    double low, double close, double change) {
        this.symbol = symbol;
        this.datetime = datetime;
        this.openPrice = open;
        this.high = high;
        this.low = low;
        this.closePrice = close;
        this.changeBar = change;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Market getMarket () {
        return market;
    }
    public void setMarket(Market market) {
        this.market = market;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public String getDatetime() {
        return datetime;
    }
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
    public double getOpen() {
        return openPrice;
    }
    public void setOpen(double open) {
        this.openPrice = open;
    }
    public double getHigh() {
        return high;
    }
    public void setHigh(double high) {
        this.high = high;
    }
    public double getLow() {
        return low;
    }
    public void setLow(double low) {
        this.low = low;
    }
    public double getClose() {
        return closePrice;
    }
    public void setClose(double close) {
        this.closePrice = close;
    }
    public double getChange() {
        return changeBar;
    }
    public void setChange(double change) {
        this.changeBar = change;
    }

}