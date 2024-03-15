package com.blit;

import java.util.Arrays;
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
            createProjectDirectory(projectName);
            createSourceFolder(projectName);
            createClassFolder(projectName);
            createMainClass(projectName, mainClassName);
            // createManifestFile(projectName);
            // createMakeFile(projectName, mainClassName);
            // createCleanFile(projectName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 

    public static void createProjectDirectory (String projectName) {
       // Create project directory.
        String dirName = "./"+projectName+"/";
        try {
            System.out.println("Creating main directory: "+dirName);
            new File(dirName).mkdirs();
        } catch (Exception e) {
            System.out.println(
            "Could not create directory: "+dirName);
            cleanDirs(projectName);
            System.exit(0);
        }
    }

    public static void createSourceFolder (String projectName) {
        // Create souce folder.
        String dirName = "./"+projectName+"/source/";
        try {
            System.out.println("Creating source folder: "+dirName);
            new File(dirName).mkdirs();
        } catch (Exception e) {
            System.out.println("Could not create source folder: "+dirName);
            cleanDirs(projectName);
            System.exit(0);
        }
    }

    public static void createClassFolder (String projectName) {
        // Create classes folder.
        String dirName = "./"+projectName+"/classes/";
        try {
            System.out.println("Creating class directory: "+dirName);
            new File(dirName).mkdirs();
        } catch (Exception e) {
            System.out.println("Could not create class folder: "+dirName);
            cleanDirs(projectName);
            System.exit(0);
        }
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
        System.out.println("Main Class: [" + mainClassName + "]");
        String[] orgName = mainClassName.split("\\.");
        
        // Create the directory structure in the 'source/' folder.
        String basePath = "./"+projectName+"/source/";
        for(int i = 0; i < orgName.length-1; i++) {
            basePath = basePath+"/"+orgName[i]+"/"; // Nest directories.
            try {
                System.out.println("Creating directory: "+basePath);
                new File(basePath).mkdirs();
            } catch (Exception e) {
                System.out.println("Cannot create dir: "+basePath);
                cleanDirs(projectName);
                System.exit(0);
            }
        }
        
        // Create path to the Main source file.
        String mainClassPath = "./"+projectName+"/source/";
        for(int i = 0; i < orgName.length-1; i++) 
            mainClassPath = mainClassPath+orgName[i]+"/";
        mainClassPath = mainClassPath+orgName[orgName.length-1]+".java";

        // Create package name to include in source file.
        String packageName = String.join(".",
            Arrays.copyOfRange(orgName, 0, orgName.length-2));
        
        System.out.println("Package name: ["+packageName+"]");
        System.out.println("Creating main class: ["+mainClassPath+"]");

        // Write out source file.
        try {
            String className = orgName[orgName.length-1];
            FileWriter writer = new FileWriter(mainClassPath);
            writer.write(
                "package "+packageName+";"+
                "\n\n" +
                "public class "+className+" {\n"+
                "\tpublic static void main (String[] args) {\n"+
                "\n"+
                "\t}\n"+
                "}"
            );
            writer.close();
        } catch (Exception e) {
            System.out.println("Could not write main class: "+mainClassPath);
            cleanDirs(projectName);
            System.exit(0);
        }
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

    public static void cleanDirs (String projectName) {
        // Remove all files created. An error has occured.
        try{
            File f = new File("./"+projectName+"/");
            f.delete();
        } catch (Exception e) {
            System.out.println("Could not clean directories.");
            System.exit(0);
        }
    }
}