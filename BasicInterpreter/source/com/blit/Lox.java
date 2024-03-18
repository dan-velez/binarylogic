/**
 * Run lexer and pipe output to parser. Lex, parse, generate, and execute code.
 */

package com.blit;

import java.io.FileReader;
// import java.util.Scanner;

public class Lox {

    private static boolean hadError;

    public Lox (String fname) {
        this.title();
        String script = "";
        try {
            FileReader reader = new FileReader(fname);
            int ch;
            while((ch = reader.read()) != -1)
                script = script+(char)ch;
            reader.close();
        } catch (Exception e) {
            System.out.println("Could not read file: ["+fname+"]");
            System.exit(0);
        }
        System.out.println("Script length: "+script.length());
        Lexer lex = new Lexer(script);
    }

    private void title () {
        System.out.println("Lox Compiler v1.0.0");
        System.out.println("-------------------");
    }

    // public void runPrompt () {
    //     this.title();
    //     System.out.println("Interactive Prompt");
    //     Scanner scan = new Scanner(System.in);

    //     while (true) {
    //         System.out.print("> ");
    //         String line = scan.nextLine();
    //         if (line == null){ break; }
    //         else {
    //             // run(line);
    //             // if(hadError) { System.exit(65); }
    //         }
    //     }
    // }
}
