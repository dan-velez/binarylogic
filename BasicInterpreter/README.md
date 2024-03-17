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

* 
