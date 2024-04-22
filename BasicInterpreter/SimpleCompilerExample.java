import java.util.*;

class Token {
    enum Type { NUMBER, PLUS, MINUS, EOF }

    final Type type;
    final String lexeme;

    Token(Type type, String lexeme) {
        this.type = type;
        this.lexeme = lexeme;
    }

    @Override
    public String toString() {
        return String.format("(%s %s)", type, lexeme);
    }
}

class Lexer {
    private final String input;
    private int position = 0;

    Lexer(String input) {
        this.input = input;
    }

    Token nextToken() {
        if (position >= input.length()) {
            return new Token(Token.Type.EOF, "");
        }

        char currentChar = input.charAt(position++);
        switch (currentChar) {
            case '+':
                return new Token(Token.Type.PLUS, "+");
            case '-':
                return new Token(Token.Type.MINUS, "-");
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                StringBuilder number = new StringBuilder();
                number.append(currentChar);
                while (position < input.length() && Character.isDigit(input.charAt(position))) {
                    number.append(input.charAt(position++));
                }
                return new Token(Token.Type.NUMBER, number.toString());
            default:
                throw new IllegalArgumentException("Invalid character: " + currentChar);
        }
    }
}

class Parser {
    private final Lexer lexer;
    private Token currentToken;

    Parser(Lexer lexer) {
        this.lexer = lexer;
        this.currentToken = lexer.nextToken();
    }

    void eat(Token.Type type) {
        if (currentToken.type == type) {
            currentToken = lexer.nextToken();
        } else {
            throw new IllegalArgumentException("Expected " + type + ", but found " + currentToken.type);
        }
    }

    int expr() {
        Token token = currentToken;
        eat(Token.Type.NUMBER);

        int result = Integer.parseInt(token.lexeme);

        while (currentToken.type == Token.Type.PLUS || currentToken.type == Token.Type.MINUS) {
            token = currentToken;
            if (token.type == Token.Type.PLUS) {
                eat(Token.Type.PLUS);
                eat(Token.Type.NUMBER);
                result += Integer.parseInt(currentToken.lexeme);
            } else if (token.type == Token.Type.MINUS) {
                eat(Token.Type.MINUS);
                eat(Token.Type.NUMBER);
                result -= Integer.parseInt(currentToken.lexeme);
            }
        }

        return result;
    }
}

public class SimpleCompilerExample {
    public static void main(String[] args) {
        String input = "10+5-3";
        Lexer lexer = new Lexer(input);
        Parser parser = new Parser(lexer);
        int result = parser.expr();
        System.out.println("Result: " + result);  // Output: 12
    }
}
