/**
 * Scan through the list of characters and group them together into the smallest 
 * sequences that still represent something. 
 * 
 * The scanner figures out what lexeme the character belongs to, and consumes it 
 * and any following characters that are part of that lexeme.
 */

package com.blit;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.blit.TokenType;

public class Lexer {
    /**
     * Perform lexical analysis on a body of text for 'lox' language.
     */
    private String text;
    private final List<Token> tokens = new ArrayList<>();

    public Lexer (String text) {
        this.text = text;
        System.out.println("Begin lexical analysis...");
        this.lex(text);
        for(Token t : tokens) {
            System.out.println(t.toString());
            System.out.println("");
        }
    }

    public List<Token> lex (String text) {
        String lexeme = "";
        int lineNum = 1;
        boolean inString = false;
        boolean inComment = false;
        boolean inIdentifier = false;

        for (int i = 0; i < text.length(); i++) {
            // System.out.println("Char: ["+text.charAt(i)+"]");
            
            // Line Numbering
            if((text.charAt(i)+"").equals("\n")) {
                lineNum++;
                inComment = false;
            }

            // String
            if(!inString) {
                if((text.charAt(i)+"").equals("\"")) {
                    inString = true;
                    lexeme = "\"";
                    continue;
                }
            }
            
            if(inString) {
                if((text.charAt(i)+"").equals("\"")) {
                    inString = false;
                    lexeme = lexeme+"\"";
                    tokens.add(new Token(
                        TokenType.STRING_LITERAL, lineNum, lexeme));
                    lexeme = "";
                    continue;
                } else {
                    lexeme = lexeme+text.charAt(i);
                }
            }

            // Line Breaks and spaces.
            if((text.charAt(i)+"").equals("\n") || 
               (text.charAt(i)+"").equals("\t") ||
               (text.charAt(i)+"").equals(" ")) {
                
                inIdentifier = false;

                // Matches Keyword at line break.
                switch (lexeme.toUpperCase()) {
                    case "AND":
                        System.out.println("Add AND token: ["+lexeme+"]");
                        tokens.add(new Token(TokenType.AND, lineNum, lexeme));
                        lexeme = "";
                        continue;
                    case "OR":
                }

                if(lexeme.length() > 0) {
                    // lexeme = "";
                    // tokens.add(new Token(
                    //     TokenType.IDENTIFIER, lineNum, lexeme));
                    // continue;
                }
            }

            // Match an identifier or keyword.
            Pattern pattern = Pattern.compile(
                "[a-z]", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text.charAt(i)+"");
            boolean found = matcher.find();
            if(found) {
                lexeme = lexeme+text.charAt(i);
                inIdentifier = true;
            }

            // Match a single char token.
        }
        return this.tokens;
    }

    private boolean handleString (char ch, int lineNum ) {
        return false;
    }
}
