# CMS Backend

## Prerequisites
This project requires you to select Java 16 in the IntelliJ project settings.

A **PostgreSQL** instance on port 5432 is also required. 

### Docker
`docker run --name postgres-db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres`

### Local Instance
[Official Download](https://www.postgresql.org/download/)

&nbsp;


|Username|Password|
|--------|--------|
|postgres|postgres|

&nbsp;

## Setup
Open the applicaiton in IntelliJ and wait for the indexing to finish. Than run the application.

&nbsp;

If you've set up the project correctly you can access out application with the following users:

|Username|Password|Role|
|--------|--------|----|
|admin|admin|Admin|


The site [http://localhost:8080/login](http://localhost:8080/login) should display the backend Login Page


## Common Issues & Fixes
* Restart the PostGreSQL Server (or Container) and verify that it is running
*	Confirm connection to the DB (e.g. in HeidiSQL)
*	Restart IntelliJ & your Spring Boot application
* In Intellij go to `View -> Tool Windows -> Gradle -> uek233-project -> Tasks -> build` and double click `clean`
* In Intellij go to `File -> Invalidate Caches -> Select All Checkboxes -> Invalidate and Restart`
* In Intellij go to `View -> Tool Windows -> Gradle` and then click on the `Reload All Gradle Projects` Icon
* If the Postman Requests doesn't work as expected, clear the Cookies and try again. If that doesn't fix the Problem, try closing all Tabs and restart Postman
