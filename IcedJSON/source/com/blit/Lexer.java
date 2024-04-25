package com.blit;

/**
 * Parse JSON files. Divide the lexer and parser into their own files. The
 * AST will be designed later. OBJECT, STRING, NUMBER, ARRAY. Design
 * seperately.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lexer {
    
    List<Map<String, String>> lexemes = new ArrayList<>();
    int index = 0;
    String json = "";
    boolean inKey = true;
    boolean inString = false;
    boolean inArray = false;

    public Map<String, Object> parseFile (String pathname) 
    throws FileNotFoundException, IOException {        
        
        FileReader reader = new FileReader(pathname);
        BufferedReader br = new BufferedReader(reader);
        String json = "";
        String line;

        while ((line = br.readLine()) != null) {
            json = json+line;
        }
        
        br.close();
        this.json = json;
        
        this.lexer();
        System.out.println("\n\nLexemes:");
        for(Map<String, String> lex : this.lexemes) {
            System.out.println(lex.toString());
        }

        return new HashMap<>();
    }

    public void lexer () {
        for (index = 0; index < json.length(); index++) {
            char ch = json.charAt(index);

            if (ch == '{' || ch == '}') continue;
            if (Character.isWhitespace(ch)) continue;

            this.lexemes.add(Map.of("KEY", this.lexKey()));
            lexValue();
        }
    }

    public String lexKey () {
        String res = "";
        if (json.charAt(index)== '"') index++;
        char ch = json.charAt(index);
        
        System.out.println("lexKey: "+ch);

        while (ch != '"') {
            res = res+ch;
            index++;
            ch = json.charAt(index);
        }

        index++;
        inKey = false;
        System.out.println("Key Formed: ["+res+"]");
        return res;
    }

    public String lexValue () {
        String res = "";
        if(json.charAt(index) == ':') index++;
        while(Character.isWhitespace(json.charAt(index))) index++;
        char ch = json.charAt(index);

        System.out.println("lexValue: "+ch);

        while (ch != ',' && ch != '}') {
            res = res+ch;
            index++;
            ch = json.charAt(index);
        }

        System.out.println("Value formed: "+res);
        res = res.trim();

        this.lexemes.add(Map.of("VALUE", res));

        return res;
    }

}