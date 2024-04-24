# React, Javascript, and Typescript #

* Standard for **React** is **Typescript**. 

* **TypeScript vs JavaScript**

* **JS** -> High level, loosley typed, weakly typed, programming language built
  into all browsers. Variables can hold any types. Loosley typed -> values are
  converted at runtime. Can add numbers to strings. Casting is done at runtime.

* `let`, `var`, `const`. `let` and `const` can exist in 3 **scopes**. 
  * **Global** - in script.
  * **functional** - in functions.
  * **block** - in if statements.

* `var` -> Global and functional ONLY due to **hoisting**. This makes `let`
  perferable to `var`. Before scope runs, the variables are created. Then it
  runs. `let` will variables hoisted to global scope. Any variable declared is
  universally available. `let` is still hoisted but cannot access until it is 
  decalred or outside its block scope. `let` and `const` can be block scoped.
  `var` is default if not declared with any keyword.

* **JS** is multiparadigm. It can be procedural, functional, and  Object 
  Oriented. Objects in JS can be **classless** (structs). And have 
  **prototypical** inheritence. There is an Object object that is inherits from
  . `.__proto__` field. Vanilla JS has encapsulation but no OOP. 

* **JS** allows anonymous inline functions to be declared w/ arrow notation. 
  Similar to lambdas in Java. The arrow is formed with `=>` sign. 
  **Event Listeners** are prime examples of using **functional programming**.

* package.json has dependencies.
* .gitignore to ignore files for upload to git.
* `npm start` creates the dev environment.
* npm buils to finish. Host files in S3 bucket. Webpage will respond. The
  build folder contains compiled application. 

* Send requests to backedn hosted on another machine.

```javascript
let c = () => console.log("Hello");
c();

(x) => x*x;

let a = {
    "name": "Tim",
    "role": "MoT"
};

let b = {
    "OSPreference": "Windows", 
    "__proto__": a
};

var x = 0;

console.log(a);
```

## Micro Service Project ##

* E-Commerce platform broken into microservices.
* 4 micro services - 2 tasks per week.
* Plan out tasks then implement code, test code, code review. 
* MongoDB. Products repository is in Mongo, not MySQL. 
* Building on legacy application. 
* 1 team per service. 

## TypeScript ##

* A superset of JS. **ALL** valid JS is valid TS. TypeScript does more. 
  Everything JS does and more. 

* TS must be transpiled into JS in order for browsers to run it. Can be used 
  for backend development if backend is in JS (Node.js).

* **Transpiled** -> Converting from languages at the same level of abstraction.
* **Compiling** -> High level to low level language.

* **TypeScript** -> Object Oriented type safe programming language. We use this
  for type saftey. Open source, managed by Microsoft.

* **enums**, **interfaces**, **access modifiers**, and other OOP features.

* **React** is function component based. 

* **TypeScript/JS Datatypes**
  * number
  * string
  * array
  * Object
  * date
  * Symbol -> Create singleton objects. Keys.
  * boolean
  * bigint
  * undefined
  * null

* **TS Specific Datatypes**
  * any - Can take any type of value. Compatibility w/ JS. Poor practice.
  * unknown - When using external api.
  * void - Return types for functions.
  * never - functions that never complete. "raise" throw errors.

* **TS** will declare variable types with `:` as well as function return types.

```typescript
let name:string = "tim";
let fruits:string[] = ["apples", "bananas"];

function myFunc():void {
  console.log("Hello");
}
```

* **TS classes** - Allows for standard inheritence using `extends`. Fields and
  methods may have access modifiers.
    * `public` - default available everywhere
    * `protected` - available to class itself and subclasses
    * `private` - avaialble only to class

* Builting support for getters and setters with `get` and `set` keywords.

* `ReadOnly` modifier - value cannot be manipulated.

## React.js ##

* A **JS/TS library** created by **Facebook** that is used to create front end
  web based applications. Very few design decisions. Tools for which user can
  decide on which to use. NOT a framework. Angular is competitor. 

* React is very **lightweight**. Because it does not make many design decisions
  for developer. Can use **JSX** with library. The many additional modules and
  plugins built for React that make it viable to use at an industry level, end
  up making the full system much heavier.

* **Redux** is a way to manage information flow around application. 

* **React** is designed to work in multiple environments. In theory, the same
  code that is used for react apps on web browsers, should also work on mobile
  apps (node.js based) and other platforms. "React Native" is React built for
  use outside web-browser generally in mobile environment. 

* **React Features** 
  * **Component Based Architecture** -> Similar to angular. Web based components
    that are swapable. Design based on components and organize using React. 

  * **Virtual DOM** -> React creates a 2nd DOM which is detached from HTML page
    and allows many changes to be made in a short period of time without 
    changing initially. After changes made, compare virtual DOM to actual DOM 
    and do a single update. Changing DOM is expensive. Efficieny tool. Updates
    less often. Makes web pages faster. 

  * **JSX/TSX** -> Java(Type)Script and XML (reference to HTML). This tool 
    allows you to write HTML code in JS or TS files that can then be rendered
    by the JS application via DOM manipulation. Components are single file
    with HTML, CSS, and JS together. 

  * **Lightweight** framework.
  
  * **Highly Supported** actively being developed.

* **React Concerns**
    * Requires significant development resources to design.
    * JSX breaks MVC design patterns by putting views inside logic classes.
    * So often updated, debugging is difficult.
    * So many modules and plugins, hard to find support for exact React env.

## Node.js ##

* Browserless runtime environment for JS. 
* Serverside JS.
* Use as a development environment. Building and designing components. 

```js
const server = createServer((req, resp) => {
    res.writeHead(200, {'Content-Type': 'text/plain'});
    res.end('Hello World\n!');
}); 

server.listen(3000, '127.0.0.1', () => {
    console.log('Listening');
});
```

* Built on Chrome's V8 JS engine.
* React will use this environment to build the files (HTML/CSS/JS) for frontend
  application. 

* Node.js comes with built in package manager for JS libs and frameworks called
  `npm`. This is used to install React and Redux libraries. 

* Node has been used by many companies Netflix, FB, Walmart, LinkedIn, Uber.
  Promotes only learning 1 language for frontend and backend. Java servers are
  more efficient, primary servers of backend. 

* Java is by far the most popular backend language to this date.


## Creating React Apps ##

* Use `npm` to create React apps.
* Transpiler, webpack (combine JS files to one) (bundler), linter (check if 
  compiles).
* npx runs without saving to disk.


## State vs Props ##

* Each component in React will have its own unique **State** object. Can store
  data that persits in rendering and re-rendering of component. 

* This data is traked so that when it is chaned, the component will re-render
  with the new data.

* State is exculsive to the individual component. Multiple instances will each
  have their own states. State is not directly accessible outside the component.

* State should be immutable. Changes to state should use the `useState` hook so
  that React can respond to changed made. 

* **Props** are values that are passed to a component from its parent 
  component. One way data flow. To achieve 2 way data flow, there needs to be
  an additional framework (**redux**).
  
* When parent's prop changes, the child re-renders. Props comes from parent,
  state is internal. Any change will re-render. Virutal DOM is compared to
  readl DOM and changes are made. 

* Common design convention is to have **Smart(logic) components** and 
  **Dumb(display) components**. 

* Smart components handle state and manipulate values. Dumb components display
  values as they inherit them via **Props** (properties).  