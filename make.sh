%jar -cvmf manifest.txt app1.jar *.class
java -jar app1.jar

# Run javac -d classes/ Class1.java Class2.java
# cd classes/
# java com.blit.Class1
# OR
# java -cp classes com.blit.Class1

# javac $(find . -name "*.java")
# javac -d classes/ source/com/blit/*.java source/com/blit/models/*.java
# javac -d ./classes/ $(find ./source/ -name "*.java")