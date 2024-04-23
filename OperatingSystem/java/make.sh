# Compile JAR from root directory.
javac -cp ./org.objectweb.asm-3.1.0.jar -d ./classes/ $(find ./source/ -name "*.java")
# cd classes/ && jar -cvmf manifest.txt ../OperatingSystem.jar $(find . -name "*.class")
# cd ../

# Run main class file.
# java -cp ./org.objectweb.asm-3.1.0.jar.jar:classes com.blit.Kernel

# Run JAR
# java -jar OperatingSystem2.jar