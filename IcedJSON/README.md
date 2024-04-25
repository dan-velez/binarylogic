# IcedJSON #
JSON parsing library and CLI program.


## TODO ##
Lexing of key-value pairs is done. TODO: Implement STRINGS, then ARRAYS, then
NESTED OBJECTS. Arrays can have objects, etc. Could get tricky.


## Parsing ##
The parser will return a HashMap of key, value pairs. 

How to parse JSON. This is the problem. Char by Char, recursivley parse
objects. Parsing problems. Can parse many languages. Learn to tokenize,
parse, and compile languages. Hacking at the language (tokens, trees).
Good domain of problems to solve: Need little reference other than the
basics of the language. High level approach... 

Solution is to LEX the JSON into key pair values first. After LEXEMES are 
created, start parsing.


## Features ##
* Parsing files
* Parsing strings
* Formatting strings