import React from "react";
import { Route, Routes } from "react-router-dom";
import CounterComponent from "../components/CounterComponent";
import CarSmartComponent from "../components/CarSmartComponent";

const AppRoutes:React.FC<unknown> = (props) => {
    return(<Routes>
        <Route element={<h3>Hello React Router</h3>} path="/" />
        <Route element={<CounterComponent startNum={4}/>} path="/counter" />
        <Route path="/car" element={<CarSmartComponent/>} />
    </Routes>);
};

export default AppRoutes;