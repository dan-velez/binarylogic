import React from 'react';
import CounterComponent from './CounterComponent';

const SecondComponent = () => {
    return (
        <div>
            <h2>Another component for testing.</h2>
            <CounterComponent startNum={3} />
        </div>
    )
};

export default SecondComponent;