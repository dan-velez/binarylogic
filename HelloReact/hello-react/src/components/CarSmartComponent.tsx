import React, { useState } from "react";
import Car from "../models/Car";
import CarDumbComponent from "./CarDumbComponent";

const CarSmartComponent:React.FC = () => {
    const[cars, setCars] = useState<Car[]>(
        [
            new Car(1, "Mazda", "RX-8", "black", "123abc", 2002, 5999),
            new Car(2, "Kia", "Rio", "Silver", "456abc", 2008, 5000),
            new Car(3, "Honda", "Civic", "black", "123sdf", 1999, 2000) 
        ]
    );

    return (<div>
        <button onClick={()=> {
            setCars([...cars, 
                new Car(4, "Honda", "CR-X", "White", "123aads", 1986, 2000)]);
        }}>Add Car</button>
        <CarDumbComponent cars={cars}/>
    </div>);
};

export default CarSmartComponent;