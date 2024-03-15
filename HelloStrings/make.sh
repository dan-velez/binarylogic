# Compile JAR from root directory.
javac -d ./classes/ $(find ./source/ -name "*.java")
cd classes/ && jar -cvmf manifest.txt ../Models.jar com

# Run main class file.
cd ../ && java -cp classes com.blit.Models