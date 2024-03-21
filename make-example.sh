## Running Java Classes ##
# cd classes/
# java com.blit.Class1
# OR
# java -cp classes com.blit.Class1


## Compiling Java Directories ##
# javac $(find . -name "*.java")
# javac -d classes/ source/com/blit/*.java source/com/blit/models/*.java
# javac -d ./classes/ $(find ./source/ -name "*.java")


## Compiling to JAR File and Running ##
jar -cvmf manifest.txt app1.jar *.class
jar -cvmf manifest.txt Models.jar com
java -jar app1.jar


## Inspect JAR ##
jar -tf app1.jar


## Adding Changes ##
# git add .
# git commit -m "Message"
# git push origin master