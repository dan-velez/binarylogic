The design pattern commonly used for implementing lexers is the Finite State Machine (FSM) or State Pattern. This pattern organizes the lexer's logic into a set of states, each representing a different mode of operation or recognition for the lexer. The lexer transitions between states based on the current input character and the rules defined for tokenization.

Here's how the Finite State Machine pattern is applied to lexer design:

States: Define a set of states, each representing a distinct phase or behavior of the lexer. For example, you may have states for recognizing identifiers, literals, operators, keywords, whitespace, and comments.

Transitions: Specify the conditions under which the lexer transitions between states. Transitions occur based on the current input character(s) and the rules defined for token recognition. For instance, when encountering a letter, the lexer transitions to the identifier state; when encountering a digit, it transitions to the numeric literal state, and so on.

Actions: Define actions associated with each state transition. These actions typically include updating the current token being recognized, advancing the input buffer, handling errors, and emitting tokens when recognition is complete.

Tokenization Logic: Implement the logic for recognizing tokens within each state. This involves scanning the input characters, applying language-specific rules for tokenization, and updating the lexer's internal state accordingly.

Error Handling: Incorporate error handling mechanisms within the FSM design to handle unexpected input patterns, syntax errors, and other lexical errors encountered during tokenization. Error states or transitions can be defined to gracefully handle such situations.

Modularity: Encapsulate the FSM logic into modular components to promote reusability, maintainability, and extensibility. Each state and transition can be implemented as a separate class or function, allowing for easy modification and customization of the lexer's behavior.

By applying the Finite State Machine pattern, the lexer's design becomes structured, modular, and easily extensible, facilitating efficient tokenization of source code for further processing by the parser and other components of the language processing pipeline.
```python
import re

class Token:
    def __init__(self, type, value):
        self.type = type
        self.value = value

class Lexer:
    def __init__(self, text):
        self.text = text
        self.pos = 0
        self.current_char = self.text[self.pos]

    def advance(self):
        self.pos += 1
        if self.pos < len(self.text):
            self.current_char = self.text[self.pos]
        else:
            self.current_char = None

    def skip_whitespace(self):
        while self.current_char is not None and self.current_char.isspace():
            self.advance()

    def integer(self):
        result = ''
        while self.current_char is not None and self.current_char.isdigit():
            result += self.current_char
            self.advance()
        return int(result)

    def float(self):
        result = ''
        while self.current_char is not None and (self.current_char.isdigit() 
            or self.current_char == '.'):
            result += self.current_char
            self.advance()
        return float(result)

    def get_next_token(self):
        while self.current_char is not None:
            if self.current_char.isspace():
                self.skip_whitespace()
                continue
            elif self.current_char.isdigit():
                return Token('INTEGER', self.integer())
            elif self.current_char == '+':
                self.advance()
                return Token('PLUS', '+')
            elif self.current_char == '-':
                self.advance()
                return Token('MINUS', '-')
            elif self.current_char == '*':
                self.advance()
                return Token('MULTIPLY', '*')
            elif self.current_char == '/':
                self.advance()
                return Token('DIVIDE', '/')
            elif self.current_char == '=':
                self.advance()
                return Token('EQUALS', '=')
            elif self.current_char == '(':
                self.advance()
                return Token('LPAREN', '(')
            elif self.current_char == ')':
                self.advance()
                return Token('RPAREN', ')')
            elif self.current_char == '{':
                self.advance()
                return Token('LBRACE', '{')
            elif self.current_char == '}':
                self.advance()
                return Token('RBRACE', '}')
            elif self.current_char == ';':
                self.advance()
                return Token('SEMICOLON', ';')
            elif self.current_char.isalpha():
                return self.identifier()
            elif self.current_char == '<':
                self.advance()
                if self.current_char == '=':
                    self.advance()
                    return Token('LESSEQUAL', '<=')
                return Token('LESS', '<')
            elif self.current_char == '>':
                self.advance()
                if self.current_char == '=':
                    self.advance()
                    return Token('GREATEREQUAL', '>=')
                return Token('GREATER', '>')
            elif self.current_char == '!':
                self.advance()
                if self.current_char == '=':
                    self.advance()
                    return Token('NOTEQUAL', '!=')
                else:
                    raise Exception('Unexpected character !')
            else:
                raise Exception('Invalid character: ' + self.current_char)

        return Token('EOF', None)

    def identifier(self):
        result = ''
        while self.current_char is not None and (self.current_char.isalnum() or 
            self.current_char == '_'):
            result += self.current_char
            self.advance()
        if result in ['if', 'else', 'while', 'int', 'float']:
            return Token('KEYWORD', result)
        return Token('IDENTIFIER', result)

# Example usage:
text = '''
if (x < 10) {
    y = 20;
} else {
    y = 30;
}
'''
lexer = Lexer(text)
token = lexer.get_next_token()
while token.type != 'EOF':
    print(token.type, token.value)
    token = lexer.get_next_token()
```