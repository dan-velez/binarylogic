import React from "react";


/* Functional Componenets are the more modern form of components. 
 * React used classes originally but they been left behind in modern
 * development. `this` is different in arrow functions thatn in declared
 * functions. There is access to window object.
 */

const FirstComponent = () => {
    /* Function called to creaete component on the DOM. */
    return (
        /* Must return a single element in TSX.*/
        <div>
            <h1>Hello, React.</h1>
            <p>Hello P element.</p>
        </div>
    );
};

export default FirstComponent;