Steps to run application
1. Download it from git 
2. go inside project directory
3. run 'mvn clean install'
4. run 'java -jar target/PlasticPOC-0.0.1-SNAPSHOT.jar'
5. open browser/rest client
6. open url (get request): http://localhost:8090/api?data=${apartments}

example search: 1. http://localhost:8090/api?data=homes
				2. http://localhost:8090/api?data=apartments

note: ${apartments} is query param
