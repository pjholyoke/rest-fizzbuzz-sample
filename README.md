# Rest-Fizzbuzz-Sample
Fizzbuzz as a REST API, using Java and Spring-Boot.

I ended up choosing the Chain of Responsibility design pattern, which also utilizes the singleton 
pattern. I chose this approach because it satisfies the Open Closed principle. With this
implementation, if I wanted to change FizzBuzz to WoofBark, I could do it by adding a new Categorizer
and adding it to the CategorizerChain class.

### Run/Build Instructions
Before starting, please ensure that the Java 8 JDK is installed.

To run the project, enter the following in t he command line:
````
./mvnw spring-boot:run
````

To build the project into a .jar file:
````
./mvnw clean package
````

The .jar file will be placed into the `/target` directory in the root of the project. 
I have included a working .jar in the bin folder of the repository.