# Compile JAR from root directory.
# javac -d ./classes/ $(find ./source/ -name "*.java")
javac -d classes/ -cp ./jars/javax.json-1.1.4.jar $(find ./source/ -name *.java)
cd classes/ && jar -cvmf manifest.txt ../AlpacaCryptoBot.jar $(find . -name "*.class")
cd ../

# Run main class file.
java -cp classes com.blit.Main

# Run JAR
# java -jar AlpacaCryptoBot.jar