Install Softwares
1. JDK8
2. Maven 

Set Path:
1. set path for JDK/JAVA_HOME
2. set mvn in path

Steps to run application
1. Download it from git 
2. go inside project directory plastic_poc/PlasticPOC
3. run 'mvn clean install'
4. run 'java -jar target/PlasticPOC-0.0.1-SNAPSHOT.jar'
5. open browser/rest client(Postman)
6. open url (get request): http://localhost:8090/api?data=${apartments}

example search: 1. http://localhost:8090/api?data=homes
		2. http://localhost:8090/api?data=apartments

note: data is query param
