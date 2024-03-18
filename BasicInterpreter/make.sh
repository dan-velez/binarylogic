# Compile JAR from root directory.
javac -d ./classes/ $(find ./source/ -name "*.java")
cd classes/ && jar -cvmf manifest.txt ../BasicInterpreter.jar $(find . -name "*.class")
cd ../

# Run main class file.
# java -cp classes com.blit.Main ./hello.lox

# Run interpreter
java -cp classes com.blit.Main ./hello.lox

# Run JAR
# java -jar BasicInterpreter.jar