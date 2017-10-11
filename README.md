# spring-running-information-analysis
## Using JPA with h2 database creating restapi mapping accomplished below:
A information analysis Restful service analyze running info request and generate health related response
* >> based on input request, create a list of runninginformation
* >> calculate heart rate and set health warning level in response
* >> POST /runninginfo?page=0&size=10
* >> GET /runninginfo/{runningId}?page=0&size=10
* >> DELETE /runninginfo/{runningId}

* Please reference configuration_images/input_output_json for sample result
* Please reference "environment setup" section to prepare runtime
* Please reference "docker&mysql setup" section to setup docker and mysql environment
* remainingissue&tobecomplete is current outstanding problem to be resolve in upcoming fixes

## Please follow below environment Setup :

* 1)Open dowloaded project in intelliJ, home directory runninginformation-analysis-service, in terminal run "$mvn clean install"

* 2)cd target[where compiled binary located] run "java -jar runninginformation-analysis-service"

* 3)open Postman, POST "http://http://127.0.0.1:8080/runninginfo" with request body can be found at configuration_images/input_output_json

* 4)open Postman, POST "http://localhost:8080/runninginfo/7c01233d-bed4-4cbd-9c28-9282a02a7038?page=0&size=10 with request body can be found at configuration_images/input_output_json

## Please follow below docker&mysql Setup :

* 1)Install docker: sudo apt-get install docker.io

* 2)Install mysql images:docker run --name nikesql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=nikesql -e MYSQL_USER=root -e MYSQL_PASSWORD=root -p 3306:3306 -d mysql/mysql-server:5.6

* 3)Check if docker image is running: docker images, you will find a container called "nikesql" is runing mysql image

* 4)get into mysql shell terminal, docker exec -it nikesql mysql -uroot -p
show databases;
......

* 5)docker exec -it nikesql bash
   cat /var/log/mysql.log

* 4)Run docker container:docker start nikesql

* 5)Stop docker containser: docker stop nikesql

* 6)check docker process: docker ps -a

* 7)configuration of the project setting can be found at configuration_images/mysql*

## Remainingissue & Tobecomplete
* 1)UserInfo is missing from result json
* 2)HealthWarningLevel is not sorted in decreasing order

