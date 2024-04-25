import React from 'react';
import logo from './logo.svg';
import './App.css';
import FirstComponent from './components/FirstComponent';
import SecondComponent from './components/SecondComponent';
import CounterComponent from './components/CounterComponent';
import CarSmartComponent from './components/CarSmartComponent';
import { BrowserRouter as Router } from 'react-router-dom';
import AppRoutes from './routes/AppRoutes';
import NavBar from './routes/NavBar';

function App() {
  return (
    <div className="App">
        <Router>
            <NavBar></NavBar>
            <AppRoutes></AppRoutes>
        </Router>
        {/* <CarSmartComponent />
        <CounterComponent startNum={-3}></CounterComponent>
        <FirstComponent></FirstComponent>
        <SecondComponent></SecondComponent> */}
    </div>
  );
}

export default App;