package com.blit;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

        createProjectDirectory(projectName);
        createSourceFolder(projectName);
        createClassFolder(projectName);
        createManifestFile(projectName);
        createMainClass(projectName, mainClassName);
        createMakeFile(projectName, mainClassName);
        createCleanFile(projectName);
    } 

    public static void createProjectDirectory (String projectName) {
       // Create project directory.
        try {
            new File("./"+projectName).mkdirs();
        } catch (Exception e) {
            System.out.println(
                "Could not create directory: [./"+projectName+"]");
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static void createSourceFolder (String projectName) {
        // Create souce folder.
        new File("./"+projectName+"/source/").mkdirs;
    }

    public static void createClassFolder (String projectName) {
        // Create classes folder.
        new File("./"+projectName+"/classes/").mkdirs;
    }

    public static void createManifestFile (String projectName) { 
        // Create manifest.txt
        FileWriter writer = new FileWriter(
            "./"+projectName+"/classes/manifest.txt");
        writer.write("Main-Class: "+mainClassName+"\n");
        writer.close();
    }

    public static void createMainClass (String projectName, 
        String mainClassName) {
        // Create main class. Split the string by '.'.
        // Create the directory structure in the 'source/' folder.
        String[] orgName = mainClassName.Split("\.");
    }

    public static void createMakeFile (String projectName, 
        String mainClassName) {
        // Create make.sh
        FileWriter writer2 = new FileWriter("./"+projectName+"/make.sh")
        writer2.write(
            "# Compile JAR from root directory." + "\n" +
            "javac -d ./classes/ $(find ./source/ -name \"*.java\")" + "\n" +
            "cd classes/ && jar -cvmf manifest.txt ../app.jar com" + "\n" +
            "cd ../" + "\n" +

            "# Run main class file." + "\n" +
            "java -cp classes " + mainClassName +  "\n" +

            "# Run JAR" + "\n" +
            "# java -jar app1.jar")
    }

    public static void createCleanFile (String projectName) {
        // Create clean.sh
    }
}