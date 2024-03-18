package com.blit;

public class Token {
    TokenType type;
    int lineNum;
    String lexeme;

    public Token (TokenType type, int lineNum, String lexeme) {
        this.type = type;
        this.lineNum = lineNum;
        this.lexeme = lexeme;
    }

    @Override
    public String toString () {
        return
        "TYPE: "+this.type+"\n"+
        "LINE:" +this.lineNum+"\n"+
        "LEXEME: ["+this.lexeme+"]";
    }
}
