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

        try {
            // createProjectDirectory(projectName);
            // createSourceFolder(projectName);
            // createClassFolder(projectName);
            // createManifestFile(projectName);
            createMainClass(projectName, mainClassName);
            // createMakeFile(projectName, mainClassName);
            // createCleanFile(projectName);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        try {
            new File("./"+projectName+"/source/").mkdirs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createClassFolder (String projectName) {
        // Create classes folder.
        new File("./"+projectName+"/classes/").mkdirs();
    }

    public static void createManifestFile (String projectName, 
    String mainClassName) { 
        // Create manifest.txt
        try {
            FileWriter writer = new FileWriter(
                "./"+projectName+"/classes/manifest.txt");
            writer.write("Main-Class: "+mainClassName+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createMainClass (String projectName, 
    String mainClassName) {
        // Create main class. Split the string by '.'.
        System.out.println("mainClassName: " + mainClassName);
        String[] orgName = mainClassName.split("\\.");
        
        // Create the directory structure in the 'source/' folder.
        for(int i = 0; i < orgName.length-1; i++) {
            new File("./"+projectName+"/source/"+orgName[i]+"/");
        }
        
        String mainClassPath = "./"+projectName+"/source/";
        for(int i = 0; i < orgName.length-1; i++) 
            mainClassPath = mainClassPath+orgName[i]+"/";
        mainClassPath = mainClassPath+orgName[orgName.length-1]+".java";

        System.out.println("Creating main class: "+mainClassPath);
        // FileWriter writer = new FileWriter("./"+projectName+"/source")

    }

    public static void createMakeFile (String projectName, 
    String mainClassName) {
        // Create make.sh
        try {
            FileWriter writer2 = new FileWriter("./"+projectName+"/make.sh");
            writer2.write(
                "# Compile JAR from root directory." + "\n" +
                "javac -d ./classes/ $(find ./source/ -name \"*.java\")" + "\n"+
                "cd classes/ && jar -cvmf manifest.txt ../app.jar com" + "\n" +
                "cd ../" + "\n" +

                "# Run main class file." + "\n" +
                "java -cp classes " + mainClassName +  "\n" +

                "# Run JAR" + "\n" +
                "# java -jar app1.jar");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createCleanFile (String projectName) {
        // Create clean.sh
    }
}