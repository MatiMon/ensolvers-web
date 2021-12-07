echo "Insert the port where is running backend app:"
read port
curl -d '{"username":"ensolvers", "password":"pass123"}' -H "Content-Type: application/json" -X POST http://localhost:$port/user
sleep 0.5
curl -d "name=myFirstFolder" -X POST http://localhost:$port/user/1/folder
sleep 0.5
curl -d "name=mySecondFolder" -X POST http://localhost:$port/user/1/folder
sleep 0.5
curl -d "name=favoriteFolder" -X POST http://localhost:$port/user/1/folder
sleep 0.5
curl -d "name=anotherFolder" -X POST http://localhost:$port/user/1/folder
sleep 0.5
curl -d "text=gym" -X POST http://localhost:$port/user/1/folder/2/toDo
sleep 0.5
curl -d "text=read" -X POST http://localhost:$port/user/1/folder/2/toDo
sleep 0.5
curl -d "text=study" -X POST http://localhost:$port/user/1/folder/2/toDo
