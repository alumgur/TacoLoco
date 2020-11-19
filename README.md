# TacoLoco

To run Taco Loco delivery customer tracker application follow the following steps:

1. Clone the project from the repo
git clone https://github.com/alumgur/TacoLoco.git

2. Navigate to the Java project

2. Build the Java project, this will create a jar file that we can run later on
mvn clean install

3. Run the Java service, note it will run on port 8080
java -jar target/tacoLoco-0.0.1-SNAPSHOT.jar

5. Navigate to the Angular project portion which is located in ../src/main/ui/src

4. Install all dependencies required for the Angular app
npm install

7. Finally run the Angular app, note it will run on port 4200
npm start

8. Navigate to localhost:4200 on your web browser to view/use the Angular App
