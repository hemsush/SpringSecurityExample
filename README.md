# SpringSecurityExample
This project provides sample code for Spring Security with MySql. It uses Spring boot, MySql, Hibernate,Bcrypt

# Requirements
1.SpringBoot
2.MySql(Version 5)
3.Hibernate
4.Maven

# Steps to run
1. Import the project in Eclipse or Spring Tool Suite and run as spring boot app


# Build the project from command prompt
mvn clean install

# Run the project 
1.mvn spring-boot:run

Go to the browser and check for http://localhost:8080/

# Set up the database
1. In the Beanconfig.java , for the first time , set the property "hibernate.hbm2ddl.auto" to create. 
2. After running for the first time , if the database properties are mentioned properly , it will create the userdetails table in the schema.
3. Run the BcryptGenerator.java with the password that needs to be used for the dashboard
4. It will give 5 hashed password. Add any one password to the backend table for a specific user (lets say admin).
5. Change the property "hibernate.hbm2ddl.auto" to update and run the application. Give the user name and password enetered in the database.
6. After successful login it will redirect to the user page.
