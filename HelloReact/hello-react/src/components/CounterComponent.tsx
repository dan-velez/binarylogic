import React, { useState } from 'react';

// Defines the props object as having a single optional field.
// startNum that is a number.
type Props = {startNum?:number};

const CounterComponent:React.FC<Props> = (props) => {
    const [count, setCount] = useState<number>(props.startNum?props.startNum:0); 

    return (
        <div>
            <button onClick={
                ()=> {
                    setCount(count-1);
                }
            }>-</button>
            <span>Count:{count}</span>
            <button onClick={
                () => {
                    setCount(count+1)
                }
            }>+</button>
        </div>
    );
};

export default CounterComponent;