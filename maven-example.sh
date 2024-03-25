# Generate Project
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app \
-DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 \
-DinteractiveMode=false

# Generate Projcet
mvn archetype:generate -DgroupId=com.blit -DartifactId=my-app \
-DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 \
-DinteractiveMode=false

# Create Package
mvn package

# Run the code
java -cp target/my-app-1.0-SNAPSHOT.jar com.blit.App
mvn exec:java -Dexec.mainClass="com.blit.App"

# Compile & Run
mvn package && java -cp target/my-app-1.0-SNAPSHOT.jar com.blit.App

# Clean
# This command will clean the project, copy dependencies, and package the 
# project (executing all phases up to package, of course).
mvn clean dependency:copy-dependencies package

# Generate docs. 
mvn site
