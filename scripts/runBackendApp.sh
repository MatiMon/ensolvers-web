cd ..
echo "Insert available port to run backend app:"
read port
mvn clean
mvn install
cd target
java -Dserver.port=$port -jar webexercise-0.0.1-SNAPSHOT.jar

