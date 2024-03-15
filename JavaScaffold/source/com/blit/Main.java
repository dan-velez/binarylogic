package com.blit;

import java.util.Scanner;
import java.io.File;
// import java.io.IOException;

public class Main {
    public static void main (String[] args) {
        System.out.println("Java Project Scaffold Tool v1.0.0");
        System.out.println("----------------------------------");
        scaffold();
    }

    public static void scaffold () {
        System.out.println("Name of project:");
        Scanner scan = new Scanner(System.in);
        String projectName = scan.nextLine();
        System.out.println("Name of main class:");
        String mainClassName = scan.nextLine();

        // Create project directory.
        try {
            new File("./"+projectName).mkdirs();
        } catch (Exception e) {
            System.out.println(
                "Could not create directory: [./"+projectName+"]");
            e.printStackTrace();
            System.exit(0);
        }
 
        // Create souce folder.
        new File("./"+projectName+"/source/").mkdirs;
 
        // Create classes folder.
        new File("./"+projectName+"/classes/").mkdirs;
 
        // Create manifest.txt
 
        // Create make.sh
 
        // Create clean.sh
 
        // Create main class. Split the string by '.'.
    } 
}