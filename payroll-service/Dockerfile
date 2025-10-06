# docker build -f payroll-service/Dockerfile -t payroll-service . (if building in the root directory)
# (uncomment other command when building in the Employeee Service directory)
# Pull the image of maven including the jdk 21 as our build tool,        AS builder -> allows you to specify steps to build the app
FROM maven:3.9.9-eclipse-temurin-21 AS builder

# Create a single location where our code will be going
WORKDIR /app

# Copy schema jar if it’s in a sibling folder
COPY ../schema /schema
RUN mvn -f /schema/pom.xml clean install

# Copy the pom.xml (includes dependencies) to the our WORKDIR /app
#COPY pom.xml .
COPY payroll-service/pom.xml .

# mvn dependency -> install the dependencies,       go-offline -B -> cache the dependencies and change only when dependencies changed for faster start-up
RUN mvn dependency:go-offline -B

# Copy the src file (in our own directory) to the ./src directory of the container
#COPY src    ./src
COPY payroll-service/src ./src

# Build the package (.jar file) that we can run -> this is the compiled version of our code
RUN mvn clean package

# After building our application, next step is to RUN it -> run the built code
FROM openjdk:21-jdk AS runner

# Set the work directory from the same directory in the builder step
WORKDIR /app

# Copy the compiled code from the builder step and put it to ./app.jar
COPY --from=builder ./app/target/payroll-service-0.0.1-SNAPSHOT.jar ./app.jar

# Expose the port where our app runs (inside the container)
EXPOSE 4001

# Starts our copied jar file to start the app
ENTRYPOINT ["java", "-jar", "app.jar"]
