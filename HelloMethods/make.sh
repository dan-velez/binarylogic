# Compile JAR from root directory.
javac -d ./classes/ $(find ./source/ -name "*.java")
cd classes/ && jar -cvmf manifest.txt ../Models.jar com
cd ../

# Run main class file.
java -cp classes com.blit.Models

# Run JAR
# java -jar app1.jar