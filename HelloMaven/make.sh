# javac -d ./target/classes/ $(find ./src/main/java/ -name "*.java")
# java -cp target/classes/ com.blit.Main

mvn compile
mvn exec:java -Dexec.mainClass="com.blit.App" # [-Dexec.args="argument1"] ...

# TAZ book of code
# Uinsg collections api is cheating. 