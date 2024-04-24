import React from 'react';
import logo from './logo.svg';
import './App.css';
import FirstComponent from './components/FirstComponent';
import SecondComponent from './components/SecondComponent';
import CounterComponent from './components/CounterComponent';
import CarSmartComponent from './components/CarSmartComponent';

function App() {
  return (
    <div className="App">
        <CarSmartComponent />
        <CounterComponent startNum={-3}></CounterComponent>
        <FirstComponent></FirstComponent>
        <SecondComponent></SecondComponent>
    </div>
  );
}

export default App;