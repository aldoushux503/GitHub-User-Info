# GitHub-User-Info

This repository contains a Java program that interacts with the GitHub API to retrieve a user's repositories and their branches.

## Installation

To run this program, you need to have the following prerequisites:

- [JDK 8+](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)

Please follow these steps to install and run the program:

1. Clone this repository to your local machine:
```shell
git clone https://github.com/aldoushux503/GitHub-User-Info.git
```

2. Navigate to the project directory::
```shell
cd GitHub-User-Info
```

3. Build and Run the program using Maven:
```shell
mvn clean install
mvn spring-boot:run
```

4. The program will start running, and you can access it through your web browser at http://localhost:8080.

## Usage 
Once the program is running, you can use it to retrieve a user's repositories and their branches. The program exposes a REST API with the following endpoint:


## Error Handling

The program handles various error scenarios and returns appropriate responses:
- If the specified GitHub user does not exist, the program returns a `404 Not Found` response with an error message.
- If the `Accept` header is set to an unsupported media type, the program returns a `406 Not Acceptable` response with an error message.
- If the `Accept` header is missing or invalid, the program returns a `400 Bad Request` response with an error message.

## Libraries Used
The program utilizes the following libraries:
- Spring Boot: Provides the framework for building the RESTful API.
- Spring Web: Enables building web
- Lombok: provides an annotations to allow you to reduce boilerplate code
