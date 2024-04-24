import React from "react";
import Car from "../models/Car";

type Props = {cars:Car[]};

const CarDumbComponent:React.FC<Props> = (props) => {
    return(<table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Make</th>
                <th>Model</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
            {props.cars.map((car:Car) => {
                return (
                    <tr>
                        <td>{car.id}</td>
                        <td>{car.brand}</td>
                        <td>{car.model}</td>
                        <td>{car.price}</td>
                    </tr>)
            })}
        </tbody>
    </table>);
};

export default CarDumbComponent;