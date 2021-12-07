echo "Insert mysql user"
read mysqlUser
mysql -h localhost -u $mysqlUser -p <"initializateDB.sql"
