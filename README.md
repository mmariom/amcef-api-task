# amcef-app-task

Welcome to the `amcef-app-task` repository. This document guides you on how to set up and run the project. There are two ways you can get the project running - via Docker or directly from your IDE.

## Pre-requisites



- Docker installed

For running the project in your IDE:

- Java 17 or later.
- Maven 

## Running the Application with Docker

First, pull the Docker image from Docker Hub:

```
docker pull mmatejovic/amcef-app-task:latest
```

Then, run the Docker container using the following command:

```
docker run -p 8080:8080 -d mmatejovic/amcef-app-task
```

The application will be running at `http://localhost:8080`.

## Running the Application in Your IDE

To run the project in your IDE, follow these steps:

1. Clone the repository:

```
git clone https://github.com/mmariom/amcef-api-task.git
```

2. Navigate to the project directory:

```
cd amcef-app-task
```
3. Import the project into your IDE.
4. Find the `ApiApp` main method in main class and run it. 

The application will be running at `http://localhost:8080`.

## Interacting with the Application

Once the application is running (either in Docker container or in your local IDE), you can visit `http://localhost:8080/swagger-ui/index.html` to see the available endpoints and interact with them.

`Total time spent on this assignment approx. 60-100 mins`
