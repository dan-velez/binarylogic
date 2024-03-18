# BasicInterpreter #
Create a BASIC interpreter using online tutorial. Work through dragon book
afterwards.

3U?C5!vkJJ4EgXz

## Notes ##
* Can create a **line-by-line interpreter**.
* Can create a **parse tree** then execute it.
* A means of loading, a module format, and exec environment.

* All lines are of form:
    * <Line> <Keyword> <Parameters> [ : <Statement> [ : ... ] ]

* goto, gosub, return, print, if, end, data, restore, read, on, rem, for, next, 
  let, input, stop, dim, randomize, tron, and troff.

* It has only two data types: **numbers and strings**.

* Variable names in this version of BASIC are strings of letters and numbers 
  that always start with a letter.

```basic
100 REM This is probably the canonical BASIC example
110 REM Program. Note that REM statements are ignored.
120 PRINT "This is a test program."
130 PRINT "Summing the values between 1 and 100"
140 LET total = 0
150 FOR I = 1 TO 100
160     LET total = total + i
170 NEXT I
180 PRINT "The total of all digits between 1 and 100 is " total
190 END
``` 

* Lexical analysis for processing the code as text
* Expression parsing, to construct parse trees of the expressions
* Statement parsing, to construct parse trees of the statements themselves
* Error classes for reporting errors in parsing

* Stack, bytecode, **Recursive descent** parser.

* The way we build programming languages is virtually unchanged.

* You start off at the bottom with the program as raw source text, literally 
 just a string of characters. Each phase analyzes the program and transforms it 
 to some higher-level representation 

* Scanning, tokens, parsing, syntax tree, analysis.

* **Lexing** -> Lexical Analysis. First step in compiler.
* A **scanner (or lexer)** takes in the linear stream of characters and chunks 
  them together into a series of something more akin to “words”.
* Thse words are refered to as **tokens**.

* **Parsing** -> This is where our syntax gets a grammar. Compose statements
  and expressions. A parser takes the flat sequence of tokens and builds a tree 
  structure that mirrors the nested nature of the grammar. **parse tree** or 
  **abstract syntax tree**.

* Parsing has a long, rich history in computer science that is closely tied to 
  the artificial intelligence community.

* Many of the techniques used today to parse programming languages were 
  originally conceived to parse human languages by AI researchers who were 
  trying to get computers to talk to us.

* The most powerful bookkeeping tool is to transform the tree into an entirely 
  new data structure that more directly expresses the semantics of the code.

* I enjoy parsing text with programming languages so creating an interpreter is
  second hand.

* Re-create lambda lisp with the lambda symbol as the function definition 
 symbol. Re-design the language. Requires a special editor.

* You can think of the compiler as a pipeline where each stage’s job is to 
 organize the data representing the user’s code in a way that makes the next 
 stage simpler to implement

* In the middle, the code may be stored in some intermediate representation (IR)

* pennyArea = 3.14159 * (0.75 / 2) * (0.75 / 2);

* Optimization techniques: 
    * “constant propagation”, 
    * “common subexpression elimination”, 
    * “loop invariant code motion”, 
    * “global value numbering”, 
    * “strength reduction”, 
    * “scalar replacement of aggregates”, 
    * “dead code elimination”, and 
    * “loop unrolling”. 

* **Generating Code** -> Last step, after optimization.
* Can generate **p-code** or portable machine code. Create a VM and an IR 
  language.VM or a mini-compiler to another machine language.

* You can write a little mini-compiler for each target architecture.
* Or you can write a virtual machine (VM), a program that emulates a 
  hypothetical chip supporting your virtual architecture at runtime. 

* The  **runtime** has all the services needed to run the code.
* if the language automatically manages memory, we need a garbage collector 
  going in order to reclaim unused bits.

* **Single-pass Compilers** -> Do not create IR code. Builds up code one rule
  at a time.

* **Tree-wal interpreter** -> Execute as it goes. No **AST**.

* **Transpiler** -> Produce other high level language code. Source to source.

* **Regular expressions** can be used to perform all types of text search and text 
  replace operations.


## Lox Language ##

* How to implement the **Lox** language.
```
// lox example.
print "Hello, world!"
```

* **Memory MGMT**:
    * Reference Counting:
    * Garbage Collection:

* **Data Types**:
    * Boolean
    * Numbers: Integers and decimals
    * Strings
    * Nil

* **Expressions**:
    * Arithmetic: Prefix, postfix, and binary
    * Comparison: <, >, =, ==, <=, >= (for numbers only)
    * Logical: !, and, or
    * Precedence and Grouping: (min + max) / 2

* **Statements**:
    * An expression that produces a value.
    * print "Hello, world!";
    * "some expression";
    * { 
        print "one";
        print "two";
      }

* **Variables**:
    * using **var** statement. Intialize to default, **nil**. 

* **Control Flow**:
    * **if**:  if (condition) { print "yes"; } else { print "no"; }
    * **while**: while (a < 10) { print a; a = a+1; }
    * **for loop**: for (var a = 1; a < 10; a++ ){ print a; }

* **Functions**:
    * makeBreakfast(egg, ham, toast);
    * fun printSum (a, b) { print a+b; }
    * print identity(addPair)(1, 2);
    * Can declare funs in other funs
    * First class objects.

* **Classes**:
```
class Breakfast {
    
    init (meat, bread) {
        this.meat = meat;
        this.bread = bread;
    }

    cook () {
        print "cook";
    }

    serve (who) {
        print "serve";
        print this.bread + ", " + who; 
    } 

}

var svar = Breakfast;
somFun(Breakfast);

var bfast = Breakfast();
print bfast;

bfast.meat = "sausage";

// Inheritance

class Brunch < Breakfast {

    drink () {
        print "Drinking";
    }

}

var ben = Brunch("ham", "English Muffin");
ben.serve("Reader");
```

* **STD Library**:
    * String manipulation
    * trigonometric functions
    * file I/O
    * reading input from the user 


