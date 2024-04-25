import React from "react";
import { Link } from "react-router-dom";

const NavBar:React.FC<unknown> = (props) => {
    return(<nav>
        <Link to={"/"}>Hello</Link>
        <hr/>
        <Link to={"/counter"}>Counter</Link>
        <hr/>
        <Link to={"/car"}>Car</Link>
        <hr/>
    </nav>)
};

export default NavBar;