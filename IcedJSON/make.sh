# Compile JAR from root directory.
javac -d ./classes/ $(find ./source/ -name "*.java")
cd classes/ && jar -cvmf manifest.txt ../IcedJSON.jar $(find . -name "*.class")
cd ../

# Run main class file.
java -cp classes com.blit.Main

# Run JAR
# java -jar IcedJSON.jar