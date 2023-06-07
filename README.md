# GitHub-User-Info

This repository contains a Java program that interacts with the GitHub API to retrieve a user's repositories and their branches.

## Installation

To run this program, you need to have the following prerequisites:

- [JDK 16+](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)

Please follow these steps to install and run the program:

1. Clone this repository to your local machine:
```shell
git clone https://github.com/aldoushux503/GitHub-User-Info.git
```

2. Navigate to the project directory:
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

Request:
- GET /repositories/{username} 
  - Path Parameters:
    - {username}: The username of the GitHub user.
  - Request Headers:
    - Accept: The media type of the response. Supported values are application/json and application/xml.
    
Response: <br />
The response format depends on the Accept header provided in the request.
- If the Accept header is application/xml, an error will be returned because this format is not currently implemented in the program.
Example Response:
```json
{
    "status": 406,
    "message": "Not acceptable media type"
}
```
- If the Accept header is application/json, the response will be a JSON object containing the user's repositories.
Example Response:
```json
[
    {
        "name": "aldoushux503",
        "owner": {
            "login": "aldoushux503"
        },
        "branches": [
            {
                "name": "main",
                "commit": {
                    "sha": "d38137b81409f1313084bc2bcf9dd1c023c2ca51",
                    "url": "https://api.github.com/repos/aldoushux503/aldoushux503/commits/d38137b81409f1313084bc2bcf9dd1c023c2ca51"
                }
            }
        ]
    }
]
```

## Error Handling

The program handles various error scenarios and returns appropriate responses:
- If the specified GitHub user does not exist, the program returns a `404 Not Found` response with an error message.
- If the `Accept` header is set to an unsupported media type, the program returns a `406 Not Acceptable` response with an error message.

## Libraries Used
The program utilizes the following libraries:
- Spring Boot: Provides the framework for building the RESTful API.
- Spring Web: Enables building web
- Lombok: provides an annotations to allow you to reduce boilerplate code
