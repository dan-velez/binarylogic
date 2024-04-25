# CryptoREST #
A REST API that stores historical crypto data. Use this API to backtest 
trading algorithms and bots. The project will have a front end in React and a 
back end using Spring.  


## Roadmap ##
* The system will have many front end components using React. Use a them such as
  inspinia and bootstrap to create components. I would like to see the ticker
  screen as well on the front end. 

* Maybe the user can select a trade algorithm to run. The trade algorithms will   
  be stored in backend. Creating a trading system using Java for trading 
  cryptocurrency. Learning more about crypto trading and trade bots. 

* Using a simple boilerplate for a ticker, then implement many algorithms. Run 
  using alpaca paper API. Study OS concepts using Java book. 

* Maybe get into compiler designing. 

* Technical trade signals. Create more algos for bot. Decouple code to remove 
  unnecessary database things. 

* Bare bones crypto ticker and algo bot. Study trading algorithms. Specialize 
  in this. Select algorithm to run on the CLI.


## REST Resources ##
### Crypto ###
```json
{
    "id": 1000,
    "symbol": "BTC/USD",
    "datetime": "01-01-2024:12:00:00Z",
    "o": 60000,
    "h": 60000,
    "l": 60000,
    "c": 60000
}
```

### Market ###
```json
{
    "name": "Alpaca",
    "market_cap": 26552729,
    "num_token": 20
}

```