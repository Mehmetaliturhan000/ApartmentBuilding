# Apartment Building Controls for ConserveIt Assignment

This is a Java application to manage heating and cooling in an apartment building.

## Features
1. User input for setting the building temperature.
2. User input for adding rooms to the building.
3. Recalculate heating/cooling status on a schedule (every 15 seconds).
4. Gradual temperature changes based on heating/cooling status.
5. Configurable "close enough" tolerance for each room, for extras
6. Decay rate setting, so decay rate can is configurable to simulate more real heating or cooling effects.

## How to Run
1. Clone the repository.
2. Build the project using Maven: `mvn clean package`.
3. Run the application: `java -jar target/apartment-building-1.0-SNAPSHOT.jar`.
4. To build and run with Docker:
   - Build the Docker image: `docker build -t apartment-building .`
   - Run the container: `docker run apartment-building`
Note: In the dockerized verison, it is impossible to enter parameters (since its working with scanner), its becasue of the nature of Docker. To see parameter entering specs please run it locally
