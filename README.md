# order-management
Assignment 2 of Web Services course (COMP4382) @ Birzeit University.

# Building the application
On the root directory of the project, run this command to build using Gradle 
```
./gradlew build
```
> .jar will be at /build/libs
# Creating and Running the Docker Image
> this section requires Docker Daemon to be running

> a dockerfile should exist

On the root directory of the project, run this command to create an image of the project
```
docker build -t order-management:tag .
```
The image should be built now.

To Run the image, type in this command:
```
docker run -p 8080:8080 order-management:tag
```
The image should be up and running now.
# Making sure the image is running

To test this you can either use the system browser or run the following command in another terminal
```
curl localhost:8080/
```
If the image ran correctly you'll be met with the following:
```
This is the root page of the Order Management Application. Please use the API endpoints to interact with the application
```
